package b.i.a.g.d;

import androidx.fragment.app.Fragment;
import com.google.android.material.datepicker.DateSelector;
import com.google.android.material.datepicker.OnSelectionChangedListener;
import java.util.LinkedHashSet;

/* compiled from: PickerFragment.java */
/* renamed from: b.i.a.g.d.i, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class PickerFragment<S> extends Fragment {
    public final LinkedHashSet<OnSelectionChangedListener<S>> onSelectionChangedListeners = new LinkedHashSet<>();

    public boolean addOnSelectionChangedListener(OnSelectionChangedListener<S> onSelectionChangedListener) {
        return this.onSelectionChangedListeners.add(onSelectionChangedListener);
    }

    public void clearOnSelectionChangedListeners() {
        this.onSelectionChangedListeners.clear();
    }

    public abstract DateSelector<S> getDateSelector();

    public boolean removeOnSelectionChangedListener(OnSelectionChangedListener<S> onSelectionChangedListener) {
        return this.onSelectionChangedListeners.remove(onSelectionChangedListener);
    }
}
