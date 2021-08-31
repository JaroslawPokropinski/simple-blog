import { PlatformLocation } from '@angular/common';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import Post from './dto/Post';


@Injectable({
  providedIn: 'root'
})
export class PostService {

  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${error.status}, body was: `, error.error);
    }
    // Return an observable with a user-facing error message.
    return throwError(
      'Something bad happened; please try again later.');
  }

  private comparePosts(p1: Post, p2: Post) {
    return p1.description === p2.description && p1.id === p2.id && p1.image === p1.image && p2.title === p2.title;
  }

    private readonly _url = 'http://localhost:8080';

    constructor(private http: HttpClient) {

    }

    getPosts(): Observable<IterableIterator<Post>> {
      return new Observable<IterableIterator<Post>>(obs => {
        const evtSource = new EventSource(`${this._url}/post`);
        const results = new Map<number, Post>();
        evtSource.addEventListener('error', (error) => {
          if(evtSource.readyState !== 0) {
            console.error('EventSource error: ' + error);
          }})
        evtSource.addEventListener('message', (evt: MessageEvent) => {
          const post = evt.data != null ? JSON.parse(evt.data) as Post : null;
          if (post != null) {
            // Only accept images from known source (imgur)
            if (post.image != null && !post.image.startsWith('https://i.imgur.com')) {
              post.image = null;
            }
            if (post.id == null) return;
            const prev = results.get(post.id);
            // If post is new or changed then add it to / replace it in map
            if (prev == null || !this.comparePosts(post, prev)) {
              results.set(post.id, post);
            }

            obs.next(results.values());
          }
        })
        return () => evtSource.close();
      })
    }

}
