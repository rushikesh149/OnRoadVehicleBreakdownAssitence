package com.ora.dao;

import java.util.List;

import com.ora.entity.Feedback;

public interface FeedbackDAO {
 public Feedback addFeedback(Feedback feedback);
 public List<Feedback> viewFeedback();

}
