package io.branch.branchster;

import android.app.Application;

import io.branch.referral.Branch;

public class BranchsterApplication extends Application {
    public void onCreate() {
        super.onCreate();
        Branch.getAutoInstance(this);
        Branch.enableLogging();
    }
}
