package com.example.todo_app.repository;

import org.springframework.data.jpa.repository.JpaRepository; // Estende CrudRepository e aggiunge molte funzionalità in più.
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.todo_app.model.Todo;

import jakarta.transaction.Transactional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Todo t WHERE t.completed = :completed")
    public void deleteCompleted(@Param("completed") boolean completed);
}
