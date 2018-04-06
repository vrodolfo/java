package com.rodolfo.dojooverflow.models;


	import java.util.ArrayList;
import java.util.Date;
	import java.util.List;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.JoinTable;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToMany;
	import javax.persistence.OneToMany;
	import javax.persistence.PrePersist;
	import javax.persistence.PreUpdate;
	import javax.persistence.Table;

	import org.springframework.format.annotation.DateTimeFormat;




	@Entity
	@Table(name="questions")
	public class Question {
	    @Id
	    @GeneratedValue
	    private Long id;
	    
	    @Column
	    private String content;
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	        name = "tags_questions", 
	        joinColumns = @JoinColumn(name = "question_id"), 
	        inverseJoinColumns = @JoinColumn(name = "tag_id")
	    )
	    private List<Tag> tags;
	    
	    @OneToMany(mappedBy="question", fetch = FetchType.LAZY)
	    private List<Answer> answers;
	    
	 // This will not allow the createdAt column to be updated after creation
	    @Column(updatable=false)
	    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	    private Date createdAt;
	    @Column
	    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	    private Date updatedAt;
	    
	    @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	    
	    public Question(String content) {
	        this.content = content;
	    }
	    
	    public Question() {
	        
	    }
	    
	    public Long getId() {
	        return id;
	    }    
	    public void setId(long id) {
	        this.id =  id;
	    }
	    
	    public String getContent() {
	        return content;
	    }
	    public void setContent(String content) {
	        this.content =  content;
	    }

	    
	    public List<Tag> getTags() {
	        return tags;
	    }
	    public void setTags(Tag tag) {
	    	if (tags == null) {
	    		tags = new ArrayList<>();
	    	}
	    	tags.add(tag);
	    }
	    
	    public List<Answer> getAnswers() {
	        return answers;
	    }
	    public void setAnswers(Answer answer) {
	    	if (answers == null) {
	    		answers = new ArrayList<>();
	    	}
	        answers.add(answer);
	    }

	}

