package example.services;

import example.exceptions.*;
import example.model.Request;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import java.util.List;


import static example.services.FileSystemService.getPathToFile;

public class RequestService {

    private static ObjectRepository<Request> requestRepository;


    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("requests.db").toFile())
                .openOrCreate("test", "test");
        requestRepository = database.getRepository(Request.class);
    }

    public static void addRequest(int id) {

        requestRepository.insert(new Request(id));

    }



    public static List<Request> getRequests()
    {
        return requestRepository.find().toList();
    }

    private static void checkRequestDoesNotAlreadyExist(int id) throws RequestAlreadyExistsException {
        for (Request request : requestRepository.find()) {
            if (request.getIdr() == id)
                throw new RequestAlreadyExistsException(id);
        }
    }


}



    





