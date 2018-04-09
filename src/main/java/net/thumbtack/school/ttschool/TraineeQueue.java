package net.thumbtack.school.ttschool;

import java.util.ArrayDeque;
import java.util.Queue;

public class TraineeQueue {
    Queue<Trainee> traineeQueue;

    public TraineeQueue() {
        traineeQueue = new ArrayDeque<>();
    }

    public void addTrainee(Trainee trainee) {
        traineeQueue.add(trainee);
    }

    public Trainee removeTrainee() throws TrainingException {
        if (!traineeQueue.isEmpty()) {
           return traineeQueue.remove();
        }else {
            throw new TrainingException(TrainingErrorCode.EMPTY_TRAINEE_QUEUE);
        }
    }
}
