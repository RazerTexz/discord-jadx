package androidx.view;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.view.SavedStateRegistry;
import b.d.b.a.outline;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class SavedStateHandle {
    private static final Class[] ACCEPTABLE_CLASSES = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};
    private static final String KEYS = "keys";
    private static final String VALUES = "values";
    private final Map<String, SavingStateLiveData<?>> mLiveDatas;
    public final Map<String, Object> mRegular;
    private final SavedStateRegistry.SavedStateProvider mSavedStateProvider;
    public final Map<String, SavedStateRegistry.SavedStateProvider> mSavedStateProviders;

    /* renamed from: androidx.lifecycle.SavedStateHandle$1, reason: invalid class name */
    public class AnonymousClass1 implements SavedStateRegistry.SavedStateProvider {
        public AnonymousClass1() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
        @NonNull
        public Bundle saveState() {
            for (Map.Entry entry : new HashMap(SavedStateHandle.this.mSavedStateProviders).entrySet()) {
                SavedStateHandle.this.set((String) entry.getKey(), ((SavedStateRegistry.SavedStateProvider) entry.getValue()).saveState());
            }
            Set<String> setKeySet = SavedStateHandle.this.mRegular.keySet();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>(setKeySet.size());
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(arrayList.size());
            for (String str : setKeySet) {
                arrayList.add(str);
                arrayList2.add(SavedStateHandle.this.mRegular.get(str));
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(SavedStateHandle.KEYS, arrayList);
            bundle.putParcelableArrayList(SavedStateHandle.VALUES, arrayList2);
            return bundle;
        }
    }

    public SavedStateHandle(@NonNull Map<String, Object> map) {
        this.mSavedStateProviders = new HashMap();
        this.mLiveDatas = new HashMap();
        this.mSavedStateProvider = new AnonymousClass1();
        this.mRegular = new HashMap(map);
    }

    public static SavedStateHandle createHandle(@Nullable Bundle bundle, @Nullable Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return new SavedStateHandle();
        }
        HashMap map = new HashMap();
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                map.put(str, bundle2.get(str));
            }
        }
        if (bundle == null) {
            return new SavedStateHandle(map);
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(KEYS);
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(VALUES);
        if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
            throw new IllegalStateException("Invalid bundle passed as restored state");
        }
        for (int i = 0; i < parcelableArrayList.size(); i++) {
            map.put((String) parcelableArrayList.get(i), parcelableArrayList2.get(i));
        }
        return new SavedStateHandle(map);
    }

    @NonNull
    private <T> MutableLiveData<T> getLiveDataInternal(@NonNull String str, boolean z2, @Nullable T t) {
        SavingStateLiveData<?> savingStateLiveData = this.mLiveDatas.get(str);
        if (savingStateLiveData != null) {
            return savingStateLiveData;
        }
        SavingStateLiveData<?> savingStateLiveData2 = this.mRegular.containsKey(str) ? new SavingStateLiveData<>(this, str, this.mRegular.get(str)) : z2 ? new SavingStateLiveData<>(this, str, t) : new SavingStateLiveData<>(this, str);
        this.mLiveDatas.put(str, savingStateLiveData2);
        return savingStateLiveData2;
    }

    private static void validateValue(Object obj) {
        if (obj == null) {
            return;
        }
        for (Class cls : ACCEPTABLE_CLASSES) {
            if (cls.isInstance(obj)) {
                return;
            }
        }
        StringBuilder sbU = outline.U("Can't put value with type ");
        sbU.append(obj.getClass());
        sbU.append(" into saved state");
        throw new IllegalArgumentException(sbU.toString());
    }

    @MainThread
    public void clearSavedStateProvider(@NonNull String str) {
        this.mSavedStateProviders.remove(str);
    }

    @MainThread
    public boolean contains(@NonNull String str) {
        return this.mRegular.containsKey(str);
    }

    @Nullable
    @MainThread
    public <T> T get(@NonNull String str) {
        return (T) this.mRegular.get(str);
    }

    @NonNull
    @MainThread
    public <T> MutableLiveData<T> getLiveData(@NonNull String str) {
        return getLiveDataInternal(str, false, null);
    }

    @NonNull
    @MainThread
    public Set<String> keys() {
        HashSet hashSet = new HashSet(this.mRegular.keySet());
        hashSet.addAll(this.mSavedStateProviders.keySet());
        hashSet.addAll(this.mLiveDatas.keySet());
        return hashSet;
    }

    @Nullable
    @MainThread
    public <T> T remove(@NonNull String str) {
        T t = (T) this.mRegular.remove(str);
        SavingStateLiveData<?> savingStateLiveDataRemove = this.mLiveDatas.remove(str);
        if (savingStateLiveDataRemove != null) {
            savingStateLiveDataRemove.detach();
        }
        return t;
    }

    @NonNull
    public SavedStateRegistry.SavedStateProvider savedStateProvider() {
        return this.mSavedStateProvider;
    }

    @MainThread
    public <T> void set(@NonNull String str, @Nullable T t) {
        validateValue(t);
        SavingStateLiveData<?> savingStateLiveData = this.mLiveDatas.get(str);
        if (savingStateLiveData != null) {
            savingStateLiveData.setValue(t);
        } else {
            this.mRegular.put(str, t);
        }
    }

    @MainThread
    public void setSavedStateProvider(@NonNull String str, @NonNull SavedStateRegistry.SavedStateProvider savedStateProvider) {
        this.mSavedStateProviders.put(str, savedStateProvider);
    }

    @NonNull
    @MainThread
    public <T> MutableLiveData<T> getLiveData(@NonNull String str, @SuppressLint({"UnknownNullness"}) T t) {
        return getLiveDataInternal(str, true, t);
    }

    public static class SavingStateLiveData<T> extends MutableLiveData<T> {
        private SavedStateHandle mHandle;
        private String mKey;

        public SavingStateLiveData(SavedStateHandle savedStateHandle, String str, T t) {
            super(t);
            this.mKey = str;
            this.mHandle = savedStateHandle;
        }

        public void detach() {
            this.mHandle = null;
        }

        @Override // androidx.view.MutableLiveData, androidx.view.LiveData
        public void setValue(T t) {
            SavedStateHandle savedStateHandle = this.mHandle;
            if (savedStateHandle != null) {
                savedStateHandle.mRegular.put(this.mKey, t);
            }
            super.setValue(t);
        }

        public SavingStateLiveData(SavedStateHandle savedStateHandle, String str) {
            this.mKey = str;
            this.mHandle = savedStateHandle;
        }
    }

    public SavedStateHandle() {
        this.mSavedStateProviders = new HashMap();
        this.mLiveDatas = new HashMap();
        this.mSavedStateProvider = new AnonymousClass1();
        this.mRegular = new HashMap();
    }
}
