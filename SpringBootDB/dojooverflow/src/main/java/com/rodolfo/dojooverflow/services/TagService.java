package com.rodolfo.dojooverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rodolfo.dojooverflow.models.Tag;
import com.rodolfo.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	
	private TagRepository tagRepository;
	
	
	public TagService(TagRepository tagRepository){
        this.tagRepository = tagRepository;
    }
	

	public List<Tag> allTags() {
	     return (List<Tag>) tagRepository.findAll();
	 }
	
	public void addTag(Tag tag) {
		tagRepository.save(tag);
	 }
	
	public Tag findTagById(Long id) {
		 return tagRepository.findById(id).orElse(null);
	}
	
	public Tag findTagByDesc(String desc) {
		 return tagRepository.findByTagName(desc);
	}

}
