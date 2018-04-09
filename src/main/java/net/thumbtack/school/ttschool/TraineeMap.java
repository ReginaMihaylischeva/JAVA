package net.thumbtack.school.ttschool;

import java.util.*;

public class TraineeMap {
    private Map<Trainee, String> traineeMap;

    public TraineeMap() {
        traineeMap = new HashMap<>();
    }

    public void addTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        if (traineeMap.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);
        } else {
            traineeMap.put(trainee, institute);

        }

    }

    public void replaceTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        if (traineeMap.containsKey(trainee)) {
            traineeMap.replace(trainee, institute);
        } else {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public void removeTraineeInfo(Trainee trainee) throws TrainingException {
        if (traineeMap.containsKey(trainee)) {
            traineeMap.remove(trainee);
        } else {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public int getTraineesCount() {
        return traineeMap.size();
    }

    public String getInstituteByTrainee(Trainee trainee) throws TrainingException {
        if (traineeMap.containsKey(trainee)) {
            return traineeMap.get(trainee);
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);

    }

    public Set<Trainee> getAllTrainees() {
        return traineeMap.keySet();
    }

    public Set<String> getAllInstitutes() {
        return new HashSet<>(traineeMap.values());
    }

    public boolean isAnyFromInstitute(String institute) {
        return getAllInstitutes().contains(institute);
    }
}
