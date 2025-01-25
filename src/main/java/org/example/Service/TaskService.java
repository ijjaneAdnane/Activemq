package org.example.Service;

import org.example.Entities.Tache;
import org.example.Repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TacheRepository taskRepository;

    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * Crée une nouvelle tâche et envoie un message JMS.
     *
     * @param tache La tâche à créer.
     * @return La tâche créée.
     */
    public Tache createTask(Tache tache) {
        Tache savedTache = taskRepository.save(tache);
        jmsTemplate.convertAndSend("task_queue", savedTache);
        return savedTache;
    }

    /**
     * Supprime une tâche par son ID et envoie un message JMS.
     *
     * @param id L'ID de la tâche à supprimer.
     */
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
        jmsTemplate.convertAndSend("task.delete", id);
    }

    /**
     * Met à jour une tâche et envoie un message JMS.
     *
     * @param tache La tâche à mettre à jour.
     * @return La tâche mise à jour.
     */
    public Tache updateTask(Tache tache) {
        Tache updatedTache = taskRepository.save(tache); // Sauvegarder et récupérer la tâche mise à jour
        jmsTemplate.convertAndSend("task.update", updatedTache); // Envoyer un message JMS
        return updatedTache; // Retourner la tâche mise à jour
    }

    /**
     * Récupère toutes les tâches.
     *
     * @return Une liste de toutes les tâches.
     */
    public List<Tache> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * Récupère une tâche par son ID.
     *
     * @param id L'ID de la tâche à récupérer.
     * @return La tâche correspondante.
     */
    public Tache getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }
}