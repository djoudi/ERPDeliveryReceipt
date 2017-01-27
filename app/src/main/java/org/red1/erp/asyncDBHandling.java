/**
 * Author red1@red1.org
 * Licensed Free as in Freedom. Anyone who does not share back will have bad karma.
 */
package org.red1.erp;

import android.content.SharedPreferences;
import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by red1 on 1/27/17.
 */

public class asyncDBHandling extends AsyncTask {

    private SharedPreferences sp;
    private List<String>scannedList;

    @Override
    protected Object doInBackground(Object[] params) {
        sp = (SharedPreferences)params[0];
        scannedList = (List)params[1];
        try {
            updateDB();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void updateDB() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection conn = null;
        conn = DriverManager.getConnection(
                sp.getString("URL","jdbc:postgresql://localhost:5432/adempiere"),
                sp.getString("User","adempiere"), sp.getString("Pass","adempiere"));
        for (String scanned : scannedList) {
            StringBuilder SQL = new StringBuilder("UPDATE BedRegistration SET DocStatus ='IP' WHERE Name='"+scanned+"'");
            Statement pstmt = conn.createStatement();
            int i = pstmt.executeUpdate(SQL.toString());
            System.out.println(scanned + " + DB result = "+i);
        }

        conn.close();
    }
}
