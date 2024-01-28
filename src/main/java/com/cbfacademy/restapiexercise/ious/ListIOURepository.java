package com.cbfacademy.restapiexercise.ious;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.cbfacademy.restapiexercise.core.PersistenceException;

//MY REPO => STORING & RETRIEVING DATA / DATA ACESS, INTERACTS W DATABASE;
@Repository
public class ListIOURepository implements IOURepository {
    final List<IOU> ious = new ArrayList<>();// ious array list

    @Override
    public List<IOU> retrieveAll() throws PersistenceException {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'retrieveAll'");
        return ious;
    }

    @Override
    // retrieve and return IOU using an id, look through the list and get this id
    // and then return this id
    public IOU retrieve(UUID id) throws IllegalArgumentException, PersistenceException {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'retrieve'");
        for (IOU iou : ious) {
            if (iou.getID().equals(id)) {
                return iou;
            }

        }
        return null;
    }

    @Override
    // create this IOU entitity and then also return it
    public IOU create(IOU entity) throws IllegalArgumentException, PersistenceException {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'create'");
        ious.add(entity);
        return entity;
    }

    @Override // remove the IOU entitty, void return type
    public void delete(IOU entity) throws IllegalArgumentException, PersistenceException {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'delete'");
        if (entity == null) {
            throw new IllegalArgumentException("parameter is empty");
        }
        ious.remove(entity);
    }

    // the purpose is to update the properties of an existing iou object w the new
    // values from the pamaramter
    @Override
    public IOU update(IOU entity) throws IllegalArgumentException, PersistenceException {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'update'");
        // look through your list, then get the iou entity from the list using any of
        // its attributes or properties, so search by id

        for (IOU iou : ious) {

            // if iou id matched the entity id , then its a match and youve found the item
            // to update, // Update the IOU entity with the properties of the entity
            // parameter, set all its attributes with attributes of entity
            if (iou.getID().equals(entity.getID())) {
                iou.setID(entity.getID());
                iou.setBorrower(entity.getBorrower());
                iou.setLender(entity.getLender());
                iou.setDateTime(entity.getDateTime());

                return iou;
            }
        }

        // If the entity is not found, throw an exception
        throw new PersistenceException("IOU with ID " + entity.getID() + " not found");
    }

    @Override
    // returns a list
    public List<IOU> searchByBorrower(String name) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'searchByBorrower'");
        // need a new array list to store my ious with borrowers that match this name
        List<IOU> borrowerList = new ArrayList<>();
        // for ebery iou object in your iou arrays list, check if the borrowers name of
        // the iou object matches the string name parameter
        for (IOU iou : ious) {
            if (iou.getBorrower().equals(name))
                // if this is true, add this iou object to your other array, the borrower's
                // array
                borrowerList.add(iou);
        }
        return borrowerList;
    }

    @Override
    public List<IOU> searchByLender(String name) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'searchByLender'");
        List<IOU> lenderList = new ArrayList<>();
        for (IOU iou : ious) {
            if (iou.getLender().equals(name))

                lenderList.add(iou);
        }
        return lenderList;

    }

}
