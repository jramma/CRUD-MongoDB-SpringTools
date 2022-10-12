package cat.itacademy.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cat.itacademy.mongo.documentos.Fruites;

public interface FruitaRepositorio  extends MongoRepository <Fruites, Integer>{

}
