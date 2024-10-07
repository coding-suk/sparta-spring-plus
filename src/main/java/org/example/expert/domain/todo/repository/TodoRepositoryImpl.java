package org.example.expert.domain.todo.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.example.expert.domain.todo.entity.QTodo;
import org.example.expert.domain.todo.entity.Todo;
import org.example.expert.domain.user.entity.QUser;

import java.util.Optional;

public class TodoRepositoryImpl implements TodoRepositoryCustom{

    private final JPAQueryFactory queryFactory;


    public TodoRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public Optional<Todo> findByIdWithUser(Long todoId) {

        QTodo qTodo = QTodo.todo;
        QUser qUser = QUser.user;

        Todo todo = queryFactory
                .selectFrom(qTodo)
                .leftJoin(qTodo.user, qUser).fetchJoin()
                .where(qTodo.id.eq(todoId)) // id.eq -> equals과 동일
                .fetchOne();

        return Optional.ofNullable(todo);
    }

}
