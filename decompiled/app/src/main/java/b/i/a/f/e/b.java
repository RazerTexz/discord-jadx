package b.i.a.f.e;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* loaded from: classes3.dex */
public class b extends DialogFragment {
    public Dialog j;
    public DialogInterface.OnCancelListener k;

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.k;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        if (this.j == null) {
            setShowsDialog(false);
        }
        return this.j;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, @Nullable String str) {
        super.show(fragmentManager, str);
    }
}
