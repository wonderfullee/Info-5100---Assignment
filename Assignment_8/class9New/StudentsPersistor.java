package class10.Assignment_8.class9New;

public interface StudentsPersistor {
    void save(StudentsManager manager) throws Exception;

    StudentsManager load() throws Exception;
}