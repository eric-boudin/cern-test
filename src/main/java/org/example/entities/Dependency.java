package org.example.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Dependency {
    private final String name;
    private final List<Dependency> dependencies;

    public Dependency(String name) {
        this.name = name;
        this.dependencies = new ArrayList<>();
    }

    public Dependency(String name, List<Dependency> dependecies) {
        this.name = name;
        this.dependencies = dependecies;
    }

    public void addDependency(Dependency dependency) {
        this.dependencies.add(dependency);
    }

    public void addAllDependencies(List<Dependency> dependencies) {
        this.dependencies.addAll(dependencies);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("- ").append(this.name);
        if(!dependencies.isEmpty()) {
            for(Dependency subDep : dependencies) {
                builder.append("\n").append(subDep.toStringAsSubDependencies(1));
            }
        }
        return builder.toString();
    }

    private String toStringAsSubDependencies(int level) {
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<level; i++) {
            builder.append("\t");
        }
        builder.append("- ").append(this.name);
        if(!dependencies.isEmpty()) {
            for(Dependency subDep : dependencies) {
                builder.append("\n").append(subDep.toStringAsSubDependencies(level+1));
            }
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dependency that = (Dependency) o;
        return Objects.equals(name, that.name) && Objects.equals(dependencies, that.dependencies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dependencies);
    }

}
