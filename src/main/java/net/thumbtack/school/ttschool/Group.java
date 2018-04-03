package net.thumbtack.school.ttschool;

import java.util.*;

public class Group {
    private String name;
    private String room;

    private List<Trainee> traines;

    public Group(String name, String room) throws TrainingException {
        setName(name);
        setRoom(room);
        traines = new ArrayList();
    }

    public void setName(String name) throws TrainingException {
        if (name == null || name.isEmpty())
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) throws TrainingException {
        if (room == null || room.isEmpty())
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_ROOM);
        this.room = room;
    }

    public List<Trainee> getTrainees() {
        return traines;
    }

    public void addTrainee(Trainee trainee) {
        traines.add(trainee);
    }

    public void removeTrainee(Trainee trainee) throws TrainingException {
        if (!traines.remove(trainee))
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);

    }

    public void removeTrainee(int index) throws TrainingException {
        if (traines.size() <= index)
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        traines.remove(index);
    }

    public Trainee getTraineeByFirstName(String firstName) throws TrainingException {

        for (Trainee traine : traines) {
            if (traine.getFirstName().equals(firstName)) {
                return traine;
            }

        }
         throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public Trainee getTraineeByFullName(String fullName) throws TrainingException {
        for (Trainee traine : traines) {
            if (traine.getFullName().equals(fullName)) {
                return traine;
            }

        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public void sortTraineeListByFirstNameAscendant() {
        traines.sort((o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
    }

    public void sortTraineeListByRatingDescendant() {
        traines.sort((o1, o2) -> o2.getRating() - o1.getRating());

    }

    public void reverseTraineeList() {
        Collections.reverse(traines);
    }

    public void rotateTraineeList(int positions) {
        if (positions > 0) {
            Collections.rotate(traines, positions);
        } else {
            reverseTraineeList();
            Collections.rotate(traines, positions * (-1));
        }
    }

    public List<Trainee> getTraineesWithMaxRating() throws TrainingException {
        List<Trainee> newT = new ArrayList();
        if (traines.isEmpty()) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        } else {
            Integer maxRating = traines.stream().mapToInt(s -> s.getRating()).max().getAsInt();
            for (Trainee traine : traines) {
                if (traine.getRating() == maxRating) {
                    newT.add(traine);
                }
            }
            return newT;
        }
    }

    public boolean hasDuplicates() {
        Set<Trainee> tempSet = new HashSet<>(traines);
        return (tempSet.size() < traines.size());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name) &&
                Objects.equals(room, group.room) &&
                Objects.equals(traines, group.traines);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, room, traines);
    }
}
