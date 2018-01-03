package main.resources.java.de.fhaachen.REST.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QWrittenExams is a Querydsl query type for WrittenExams
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWrittenExams extends EntityPathBase<WrittenExams> {

    private static final long serialVersionUID = 1546919695L;

    public static final QWrittenExams writtenExams = new QWrittenExams("writtenExams");

    public final NumberPath<Float> grade = createNumber("grade", Float.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> student_id = createNumber("student_id", Integer.class);

    public final NumberPath<Integer> subject_id = createNumber("subject_id", Integer.class);

    public QWrittenExams(String variable) {
        super(WrittenExams.class, forVariable(variable));
    }

    public QWrittenExams(Path<? extends WrittenExams> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWrittenExams(PathMetadata metadata) {
        super(WrittenExams.class, metadata);
    }

}

