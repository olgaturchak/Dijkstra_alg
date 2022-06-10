package com.company;

public class Scene {
    SceneSpecification sceneSpecification;
    Event event;

    public Scene(SceneSpecification sceneSpecification, Event event) {
        this.sceneSpecification = sceneSpecification;
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }

    public SceneSpecification getSceneSpecification() {
        return sceneSpecification;
    }

    @Override
    public String toString() {
        return "Scene: " +
                sceneSpecification + event;
    }
}
