package androidx.preference;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;

@Deprecated
/* loaded from: classes.dex */
public class ListPreferenceDialogFragment extends PreferenceDialogFragment {
    private static final String SAVE_STATE_ENTRIES = "ListPreferenceDialogFragment.entries";
    private static final String SAVE_STATE_ENTRY_VALUES = "ListPreferenceDialogFragment.entryValues";
    private static final String SAVE_STATE_INDEX = "ListPreferenceDialogFragment.index";
    public int mClickedDialogEntryIndex;
    private CharSequence[] mEntries;
    private CharSequence[] mEntryValues;

    /* renamed from: androidx.preference.ListPreferenceDialogFragment$1, reason: invalid class name */
    public class AnonymousClass1 implements DialogInterface.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            ListPreferenceDialogFragment listPreferenceDialogFragment = ListPreferenceDialogFragment.this;
            listPreferenceDialogFragment.mClickedDialogEntryIndex = i;
            listPreferenceDialogFragment.onClick(dialogInterface, -1);
            dialogInterface.dismiss();
        }
    }

    @Deprecated
    public ListPreferenceDialogFragment() {
    }

    private ListPreference getListPreference() {
        return (ListPreference) getPreference();
    }

    @Deprecated
    public static ListPreferenceDialogFragment newInstance(String str) {
        ListPreferenceDialogFragment listPreferenceDialogFragment = new ListPreferenceDialogFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        listPreferenceDialogFragment.setArguments(bundle);
        return listPreferenceDialogFragment;
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.mClickedDialogEntryIndex = bundle.getInt(SAVE_STATE_INDEX, 0);
            this.mEntries = bundle.getCharSequenceArray(SAVE_STATE_ENTRIES);
            this.mEntryValues = bundle.getCharSequenceArray(SAVE_STATE_ENTRY_VALUES);
            return;
        }
        ListPreference listPreference = getListPreference();
        if (listPreference.getEntries() == null || listPreference.getEntryValues() == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        this.mClickedDialogEntryIndex = listPreference.findIndexOfValue(listPreference.getValue());
        this.mEntries = listPreference.getEntries();
        this.mEntryValues = listPreference.getEntryValues();
    }

    @Override // androidx.preference.PreferenceDialogFragment
    @Deprecated
    public void onDialogClosed(boolean z2) {
        int i;
        ListPreference listPreference = getListPreference();
        if (!z2 || (i = this.mClickedDialogEntryIndex) < 0) {
            return;
        }
        String string = this.mEntryValues[i].toString();
        if (listPreference.callChangeListener(string)) {
            listPreference.setValue(string);
        }
    }

    @Override // androidx.preference.PreferenceDialogFragment
    public void onPrepareDialogBuilder(AlertDialog.Builder builder) {
        super.onPrepareDialogBuilder(builder);
        builder.setSingleChoiceItems(this.mEntries, this.mClickedDialogEntryIndex, new AnonymousClass1());
        builder.setPositiveButton((CharSequence) null, (DialogInterface.OnClickListener) null);
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(SAVE_STATE_INDEX, this.mClickedDialogEntryIndex);
        bundle.putCharSequenceArray(SAVE_STATE_ENTRIES, this.mEntries);
        bundle.putCharSequenceArray(SAVE_STATE_ENTRY_VALUES, this.mEntryValues);
    }
}
