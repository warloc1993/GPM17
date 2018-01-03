package main.resources.java.de.fhaachen.REST.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSubjects is a Querydsl query type for Subjects
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSubjects extends EntityPathBase<Subjects> {

    private static final long serialVersionUID = -871446663L;

    public static final QSubjects subjects = new QSubjects("subjects");

    public final NumberPath<Integer> ects = createNumber("ects", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public QSubjects(String variable) {
        super(Subjects.class, forVariable(variable));
    }

    public QSubjects(Path<? extends Subjects> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSubjects(PathMetadata metadata) {
        super(Subjects.class, metadata);
    }

}

