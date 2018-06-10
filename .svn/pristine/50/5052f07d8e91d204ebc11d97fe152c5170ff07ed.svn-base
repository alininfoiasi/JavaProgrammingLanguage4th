package ch15;

@interface ClassInfo {

    String created();

    String createdBy();

    String lastModified();

    String lastModifiedBy();

    Revision revision();
}

@interface Revision {

    int major() default 1;

    int minor() default 0;
}

@ClassInfo(
        created = "Jan 31 2005",
        createdBy = "James Gosling",
        lastModified = "Jun 8 2013",
        lastModifiedBy = "Alin R.",
        revision = @Revision(minor = 1))
public class Annotations {
}
