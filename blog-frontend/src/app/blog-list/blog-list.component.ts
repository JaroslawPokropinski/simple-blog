import { Component, OnInit } from '@angular/core';
import Post from '../dto/Post';
import { PostService } from '../post.service';

@Component({
  selector: 'app-blog-list',
  templateUrl: './blog-list.component.html',
  styleUrls: ['./blog-list.component.scss']
})
export class BlogListComponent implements OnInit {

  public posts: Array<Post> = [];

  constructor(private postService: PostService) { }


  ngOnInit(): void {
    // this.postService.getPosts().subscribe((posts) => {
    //   posts.forEach(post => this.posts.push(post))
    // })
    this.postService.getPosts().subscribe((posts) => {
      this.posts = [...posts];
    })
  }

}
