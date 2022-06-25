package com.sttmanageweb.service.sttmanagewebservicespringboot.web.dto;


import com.sttmanageweb.service.sttmanagewebservicespringboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public Posts toEntity(){
        return Posts.builder()
                .author(author).content(content).title(title).build();
    }
}
