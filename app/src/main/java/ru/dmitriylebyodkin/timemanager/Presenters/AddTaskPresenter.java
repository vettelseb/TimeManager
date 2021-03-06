package ru.dmitriylebyodkin.timemanager.Presenters;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.Calendar;

import ru.dmitriylebyodkin.timemanager.App;
import ru.dmitriylebyodkin.timemanager.Models.LabelModel;
import ru.dmitriylebyodkin.timemanager.Models.TaskModel;
import ru.dmitriylebyodkin.timemanager.Room.Dao.TaskDao;
import ru.dmitriylebyodkin.timemanager.Room.Data.Label;
import ru.dmitriylebyodkin.timemanager.Room.Data.Task;
import ru.dmitriylebyodkin.timemanager.Room.RoomDb;
import ru.dmitriylebyodkin.timemanager.Views.AddTaskView;

/**
 * Created by dmitr on 08.03.2018.
 */

@InjectViewState
public class AddTaskPresenter extends MvpPresenter<AddTaskView> {
    private static final String TAG = "myLogs";

    public AddTaskPresenter() {

    }

    public void showDescriptionDialog() {
        getViewState().showDescriptionDialog();
    }

    public void updateDescription(String text) {
        getViewState().updateDescription(text);
    }

    public void addTask(RoomDb roomDb, Task task) {
        long taskId = TaskModel.insert(roomDb, task);
        Log.d(TAG, "addTask: " + task.getLabel());

        getViewState().finishAdd(taskId);
    }

    public void updateTask(TaskDao taskDao, Task task) {
        TaskModel.update(taskDao, task);

        getViewState().finishEdit();
    }

    public void delete(TaskDao taskDao, int id) {
        TaskModel.delete(taskDao, id);
    }

    public void showDifficultyDialog() {
        getViewState().showDifficultyDialog();
    }

    public void updateDifficulty(int i) {
        getViewState().updateDifficulty(i);
    }

    public void updateDateStart(long millis) {
        getViewState().updateDateStart(millis);
    }

    public void showDeadlinesDialog(boolean isStart) {
        getViewState().showDeadlinesDialog(isStart);
    }

    public void updateDeadline(long millis) {
        getViewState().updateDeadline(millis);
    }

    public void showPlanTimeDialog() {
        getViewState().showPlanTimeDialog();
    }

    public void updatePlanTime(int time, int unit) {
        getViewState().updatePlanTime(time, unit);
    }

    public void showLabelDialog() {
        getViewState().showLabelDialog();
    }

    public void updateLabel(int position) {
        getViewState().updateLabel(position);
    }

    public long addLabel(RoomDb roomDb, String title) {
        Label label = new Label();
        label.setTitle(title);
        label.setImageId(0);

//        getViewState().addLabel(label);

        return LabelModel.insert(roomDb, label);
    }
}
