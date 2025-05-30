package com.project.HospitalManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ObjectList<T extends Entity> {
    private List<T> objects = new ArrayList<>();

    // Create
    public void create(T object) {
        try {
            if (object == null) {
                throw new IllegalArgumentException("Object cannot be null");
            }
            objects.add(object);
            System.out.println("Created: " + object);
        } catch (Exception e) {
            System.err.println("Error creating object: " + e.getMessage());
        }
    }

    // Read
    public Optional<T> read(int id) {
        try {
            return objects.stream()
                    .filter(obj -> obj.getId() == id)
                    .findFirst();
        } catch (Exception e) {
            System.err.println("Error reading object: " + e.getMessage());
            return Optional.empty();
        }
    }

    // Update
    public void update(int id, T updatedObject) {
        try {
            if (updatedObject == null) {
                throw new IllegalArgumentException("Updated object cannot be null");
            }
            for (int i = 0; i < objects.size(); i++) {
                if (objects.get(i).getId() == id) {
                    objects.set(i, updatedObject);
                    System.out.println("Updated: " + updatedObject);
                    return;
                }
            }
            throw new IllegalArgumentException("Object with ID " + id + " not found");
        } catch (Exception e) {
            System.err.println("Error updating object: " + e.getMessage());
        }
    }

    // Delete
    public void delete(int id) {
        try {
            boolean removed = objects.removeIf(obj -> obj.getId() == id);
            if (removed) {
                System.out.println("Deleted object with ID: " + id);
            } else {
                throw new IllegalArgumentException("Object with ID " + id + " not found");
            }
        } catch (Exception e) {
            System.err.println("Error deleting object: " + e.getMessage());
        }
    }

    public List<T> getAll() {
        try {
            return new ArrayList<>(objects);
        } catch (Exception e) {
            System.err.println("Error retrieving objects: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
