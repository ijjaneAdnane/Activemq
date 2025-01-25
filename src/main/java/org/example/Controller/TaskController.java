package org.example.Controller;

import org.example.Entities.Tache;
import org.example.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    /**
     * Endpoint pour créer une nouvelle tâche.
     *
     * @param tache La tâche à créer (passée dans le corps de la requête).
     * @return La tâche créée.
     */
    @PostMapping
    public ResponseEntity<Tache> createTask(@RequestBody Tache tache) {
        Tache createdTask = taskService.createTask(tache);
        return ResponseEntity.ok(createdTask);
    }

    /**
     * Endpoint pour supprimer une tâche par son ID.
     *
     * @param id L'ID de la tâche à supprimer.
     * @return Réponse HTTP 200 (OK) si la suppression est réussie.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Endpoint pour mettre à jour une tâche existante.
     *
     * @param tache La tâche à mettre à jour (passée dans le corps de la requête).
     * @return La tâche mise à jour.
     */
    @PutMapping
    public ResponseEntity<Tache> updateTask(@RequestBody Tache tache) {
        Tache updatedTask = taskService.updateTask(tache); // Utiliser la méthode qui retourne Tache
        return ResponseEntity.ok(updatedTask);
    }

    /**
     * Endpoint pour récupérer toutes les tâches.
     *
     * @return Une liste de toutes les tâches.
     */
    @GetMapping
    public ResponseEntity<List<Tache>> getAllTasks() {
        List<Tache> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    /**
     * Endpoint pour récupérer une tâche par son ID.
     *
     * @param id L'ID de la tâche à récupérer.
     * @return La tâche correspondante.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Tache> getTaskById(@PathVariable Long id) {
        Tache task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }
}