package com.cbfacademy.restapiexercise.ious;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

//SERVICE => Coordinator of Actions, MIDDLEMAN for communication , interact w Repository to fulfill requests 
@Service
public class ListIOUService implements IOUService {
    final List<IOU> ious = new ArrayList<>();

    // connection point to the data storage system- repo, giving the service access
    // to a set of tools or methods for managing the data
    public ListIOUService(IOURepository iouRepository) {

    }

    @Override
    public List<IOU> getAllIOUs() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getAllIOUs'");
        return ious;
    }

    @Override
    public IOU getIOU(UUID id) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getIOU'");
        // look for IOU with ID of parameter in the list
        for (IOU iou : ious) {
            if (iou.getID().equals(id)) {
                return iou;
            }
        }

        return null;
    }

    @Override
    public IOU createIOU(IOU iou) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'createIOU'");
        ious.add(iou);
        return iou;
    }

    @Override
    public IOU updateIOU(UUID id, IOU updatedIOU) {
        // Find this IOU id in your list and update it to this update IOU's id
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'updateIOU'");
        for (IOU iou : ious) {
            if (iou.getID().equals(id)) {
                iou.setID(updatedIOU.getID());
                return iou;
            }
        }
        return null;
    }

    @Override
    public void deleteIOU(UUID id) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'deleteIOU'");
        // create a seperate list to store removed IOUS
        List<IOU> removeList = new ArrayList<>();

        for (IOU iou : ious) {
            if (iou.getID().equals(id)) {
                removeList.add(iou);
                ious.removeAll(removeList);
            }
        }

    }
}
