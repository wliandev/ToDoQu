package com.example.todoquadrant;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Task> tasks;
    private ArrayAdapter<Task> tasksAdapter;
    private ListView lvTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tasks = new ArrayList<Task>();
        lvTasks = findViewById(R.id.lvTasks);

        tasksAdapter = new TaskAdapter(this, tasks);
        lvTasks.setAdapter(tasksAdapter);

        tasks.add(new Task("Sketch out GUI", 1));
        tasks.add(new Task("Write code", 1));
        tasks.add(new Task("Call Mom after dinner", 1));

    }

    public void addTaskDialog(View view){
        final EditText taskDescription = new EditText(this);
        //final Spinner importance = new Spinner(this, 1);
        //final Spinner urgency = new Spinner(this);

        AlertDialog.Builder addDialog = new AlertDialog.Builder(this);
        addDialog.setTitle("Add New Task");
        addDialog.setMessage("Describe and rate the task below!");
        addDialog.setView(taskDescription);
        //addDialog.setView(importance);
        //addDialog.setView(urgency);


        //addDialog.setPositiveButton("Add", );
        //addDialog.setNegativeButton("Cancel", null);

        addDialog.create();
        addDialog.show();

    }


    public void deleteTask(View view){
        View parent = (View)view.getParent();
        TextView taskView = parent.findViewById(R.id.textView_id);
        String description = String.valueOf(taskView.getText());
        tasks.remove(searchTask(description));
        tasksAdapter.notifyDataSetChanged();
    }

    public void addTask(View view){
        //String description;
        //int priority;
        //tasks.add(new Task(description, priority));
        //tasksAdapter.notifyDataSetChanged();

    }

    public Task searchTask(String string) {
        for (Task t : tasks){
            if (t.getDescription().equals(string)){
                return t;
            }
        }
        return null;
    }
}
