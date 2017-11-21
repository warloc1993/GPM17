package main.resources.java.de.fhaachen.REST.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStudent is a Querydsl query type for Student
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudent extends EntityPathBase<Student> {

    private static final long serialVersionUID = 376270153L;

    public static final QStudent student = new QStudent("student");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> passed_bachelor_thesis = createNumber("passed_bachelor_thesis", Integer.class);

    public final NumberPath<Integer> passed_colloquium = createNumber("passed_colloquium", Integer.class);

    public final NumberPath<Integer> passed_practice_project = createNumber("passed_practice_project", Integer.class);

    public final StringPath prename = createString("prename");

    public QStudent(String variable) {
        super(Student.class, forVariable(variable));
    }

    public QStudent(Path<? extends Student> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStudent(PathMetadata metadata) {
        super(Student.class, metadata);
    }

}

