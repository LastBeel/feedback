package hello;

public interface ClientService {
        Client findClientByUsername(String email);
        void saveClient(Client c);

}
