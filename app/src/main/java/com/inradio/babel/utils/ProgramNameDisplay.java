package com.inradio.babel.utils;

import android.os.AsyncTask;
import android.util.Log;

import com.inradio.babel.data.constant.AppConstants;
import com.inradio.babel.model.Program;
import com.inradio.babel.model.ProgramTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class ProgramNameDisplay extends AsyncTask<ArrayList<Program>, Void, String[]> {

    private ProgramNameDisplayListener listener;

    public void setListener(ProgramNameDisplayListener listener) {
        this.listener = listener;
    }


    @Override
    protected String[] doInBackground(ArrayList<Program>[] arrayLists) {
        Log.d("DataTesting", "Called");
        for (Program program : arrayLists[0]) {
            ProgramTime programStartTime = AppUtility.getTime(program.getProgramStartTime());
            ProgramTime programEndTime = AppUtility.getTime(program.getProgramEndTime());

            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
            Date date = new Date();
            String currentTime = sdf.format(date);

            try {
                Date currentHourMinute = sdf.parse(currentTime);
                Date startTime = sdf.parse(programStartTime.getTime());
                Date endTime = sdf.parse(programEndTime.getTime());
                if ((currentHourMinute.after(startTime)) && (currentHourMinute.before(endTime)) || currentHourMinute.equals(startTime) || currentHourMinute.equals(endTime)) {
                    Log.d("DataTesting", program.getProgramName());
                    return new String[]{program.getProgramName(), program.getProgramHostName()};
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    protected void onPostExecute(String[] strings) {
        super.onPostExecute(strings);
        if (strings != null && strings.length != AppConstants.INDEX_ZERO) {
            Log.d("DataTesting", ""+strings[0]+" "+strings[1]);
            listener.onProgramNameFound(strings[0], strings[1]);
        }
    }

    public interface ProgramNameDisplayListener {
        void onProgramNameFound(String programName, String hostName);
    }

}
