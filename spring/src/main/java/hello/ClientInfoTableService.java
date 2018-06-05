package hello;

public interface ClientInfoTableService {
        ClientInfoTable findClientByUsername(String email);
        void saveClient(ClientInfoTable c);

}
