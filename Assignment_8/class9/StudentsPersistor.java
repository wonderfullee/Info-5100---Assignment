package class10.Assignment_8.class9;

public interface StudentsPersistor {
    void save(StudentsManager manager) throws Exception;

    StudentsManager load() throws Exception;
}