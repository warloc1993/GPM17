package main.resources.java.de.fhaachen.REST.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QThesis is a Querydsl query type for Thesis
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QThesis extends EntityPathBase<Thesis> {

    private static final long serialVersionUID = -109324802L;

    public static final QThesis thesis = new QThesis("thesis");

    public final NumberPath<Integer> approved = createNumber("approved", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> student_id = createNumber("student_id", Integer.class);

    public final StringPath supervisor = createString("supervisor");

    public final StringPath title = createString("title");

    public QThesis(String variable) {
        super(Thesis.class, forVariable(variable));
    }

    public QThesis(Path<? extends Thesis> path) {
        super(path.getType(), path.getMetadata());
    }

    public QThesis(PathMetadata metadata) {
        super(Thesis.class, metadata);
    }

}

