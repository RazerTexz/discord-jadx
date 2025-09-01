package com.discord.utilities.stateful;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.ViewDialogConfirmationBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.TextWatcher4;
import com.discord.views.CheckedSetting;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.StringsJVM;
import d0.t.Iterables2;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.functions.Func0;

/* compiled from: StatefulViews.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u00016B\u0015\u0012\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030,¢\u0006\u0004\b0\u00101B\u0015\b\u0016\u0012\n\u0010-\u001a\u000202\"\u00020\u0003¢\u0006\u0004\b0\u00103B\u0017\b\u0016\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r04¢\u0006\u0004\b0\u00105J\u001d\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\tJ3\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u000f\"\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0014\u001a\u00020\u00112\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u000f\"\u00020\r¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0019J\u001d\u0010\u001a\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u001a\u0010\u0006J#\u0010\u001c\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00028\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\"\u0010#J\u0015\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0003¢\u0006\u0004\b%\u0010&R6\u0010)\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010'j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001`(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R2\u0010+\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070'j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007`(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010*R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R6\u0010/\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010'j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001`(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010*¨\u00067"}, d2 = {"Lcom/discord/utilities/stateful/StatefulViews;", "", ExifInterface.GPS_DIRECTION_TRUE, "", ModelAuditLogEntry.CHANGE_KEY_ID, "get", "(I)Ljava/lang/Object;", "", "isAnyRequiredFieldBlank", "()Z", "hasAnythingChanged", "Lcom/discord/app/AppFragment;", "fragment", "Landroid/view/View;", "saveAction", "", "views", "", "setupTextWatcherWithSaveAction", "(Lcom/discord/app/AppFragment;Landroid/view/View;[Landroid/view/View;)V", "addOptionalFields", "([Landroid/view/View;)V", "setupUnsavedChangesConfirmation", "(Lcom/discord/app/AppFragment;)V", "defaultValue", "(ILjava/lang/Object;)Ljava/lang/Object;", "getIfChanged", "value", "put", "(ILjava/lang/Object;)V", "clearDefaults", "clear", "(Z)V", "saveActionView", "configureSaveActionView", "(Landroid/view/View;)V", "viewId", "hasChanged", "(I)Z", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "viewValuesEdited", "Ljava/util/HashMap;", "requiredFieldIds", "", "ids", "Ljava/util/List;", "viewValues", "<init>", "(Ljava/util/List;)V", "", "([I)V", "", "(Ljava/util/Collection;)V", "FragmentOnBackPressedHandler", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StatefulViews {
    private final List<Integer> ids;
    private final HashMap<Integer, Boolean> requiredFieldIds;
    private final HashMap<Integer, Object> viewValues;
    private final HashMap<Integer, Object> viewValuesEdited;

    /* compiled from: StatefulViews.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0019\u0010\u000e\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/discord/utilities/stateful/StatefulViews$FragmentOnBackPressedHandler;", "", "", "onBackPressed", "()Z", "Lkotlin/Function0;", "hasAnythingChanged", "Lkotlin/jvm/functions/Function0;", "getHasAnythingChanged", "()Lkotlin/jvm/functions/Function0;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "discardConfirmed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Landroid/app/Activity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function0;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class FragmentOnBackPressedHandler {
        private final Activity activity;
        private final AtomicBoolean discardConfirmed;
        private final Function0<Boolean> hasAnythingChanged;

        public FragmentOnBackPressedHandler(Activity activity, Function0<Boolean> function0) {
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Intrinsics3.checkNotNullParameter(function0, "hasAnythingChanged");
            this.activity = activity;
            this.hasAnythingChanged = function0;
            this.discardConfirmed = new AtomicBoolean(false);
        }

        public static final /* synthetic */ AtomicBoolean access$getDiscardConfirmed$p(FragmentOnBackPressedHandler fragmentOnBackPressedHandler) {
            return fragmentOnBackPressedHandler.discardConfirmed;
        }

        public final Activity getActivity() {
            return this.activity;
        }

        public final Function0<Boolean> getHasAnythingChanged() {
            return this.hasAnythingChanged;
        }

        public final boolean onBackPressed() {
            if (!this.hasAnythingChanged.invoke().booleanValue() || this.discardConfirmed.get()) {
                return false;
            }
            ViewDialogConfirmationBinding viewDialogConfirmationBindingB = ViewDialogConfirmationBinding.b(LayoutInflater.from(this.activity));
            Intrinsics3.checkNotNullExpressionValue(viewDialogConfirmationBindingB, "ViewDialogConfirmationBi…tInflater.from(activity))");
            AlertDialog alertDialogCreate = new AlertDialog.Builder(this.activity).setView(viewDialogConfirmationBindingB.a).create();
            Intrinsics3.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(acti…logBinding.root).create()");
            viewDialogConfirmationBindingB.d.setText(R.string.discard_changes);
            viewDialogConfirmationBindingB.e.setText(R.string.discard_changes_description);
            viewDialogConfirmationBindingB.f2185b.setOnClickListener(new StatefulViews6(alertDialogCreate));
            viewDialogConfirmationBindingB.c.setText(R.string.okay);
            viewDialogConfirmationBindingB.c.setOnClickListener(new StatefulViews7(this, alertDialogCreate));
            alertDialogCreate.show();
            return true;
        }
    }

    /* compiled from: StatefulViews.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/view/View;", "", "invoke", "(Landroid/view/View;)V", "smartHide"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.stateful.StatefulViews$configureSaveActionView$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "$this$smartHide");
            if (view instanceof FloatingActionButton) {
                ((FloatingActionButton) view).hide();
            } else {
                view.setVisibility(8);
            }
        }
    }

    /* compiled from: StatefulViews.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/view/View;", "", "invoke", "(Landroid/view/View;)V", "smartShow"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.stateful.StatefulViews$configureSaveActionView$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<View, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "$this$smartShow");
            if (view instanceof FloatingActionButton) {
                ((FloatingActionButton) view).show();
            } else {
                view.setVisibility(0);
            }
        }
    }

    /* compiled from: StatefulViews.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "()Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.stateful.StatefulViews$setupUnsavedChangesConfirmation$1, reason: invalid class name */
    public static final class AnonymousClass1<R> implements Func0<Boolean> {
        public final /* synthetic */ FragmentOnBackPressedHandler $onBackPressedHandler;

        public AnonymousClass1(FragmentOnBackPressedHandler fragmentOnBackPressedHandler) {
            this.$onBackPressedHandler = fragmentOnBackPressedHandler;
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            FragmentOnBackPressedHandler fragmentOnBackPressedHandler = this.$onBackPressedHandler;
            return fragmentOnBackPressedHandler != null ? Boolean.valueOf(fragmentOnBackPressedHandler.onBackPressed()) : Boolean.FALSE;
        }
    }

    public StatefulViews(List<Integer> list) {
        Intrinsics3.checkNotNullParameter(list, "ids");
        this.ids = list;
        this.viewValues = new HashMap<>();
        this.viewValuesEdited = new HashMap<>();
        this.requiredFieldIds = new HashMap<>();
    }

    public static final /* synthetic */ boolean access$hasAnythingChanged(StatefulViews statefulViews) {
        return statefulViews.hasAnythingChanged();
    }

    public static /* synthetic */ void clear$default(StatefulViews statefulViews, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        statefulViews.clear(z2);
    }

    private final <T> T get(int id2) {
        return (T) (this.viewValuesEdited.containsKey(Integer.valueOf(id2)) ? this.viewValuesEdited : this.viewValues).get(Integer.valueOf(id2));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean hasAnythingChanged() {
        boolean z2;
        List<Integer> list = this.ids;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                if (this.viewValuesEdited.containsKey(Integer.valueOf(iIntValue))) {
                    Object string = this.viewValuesEdited.get(Integer.valueOf(iIntValue));
                    if (string instanceof SpannableStringBuilder) {
                        string = string.toString();
                    }
                    z2 = Intrinsics3.areEqual(string, this.viewValues.get(Integer.valueOf(iIntValue)) instanceof SpannableStringBuilder ? String.valueOf(this.viewValues.get(Integer.valueOf(iIntValue))) : this.viewValues.get(Integer.valueOf(iIntValue))) ^ true;
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isAnyRequiredFieldBlank() {
        boolean z2;
        HashMap<Integer, Boolean> map = this.requiredFieldIds;
        if (!map.isEmpty()) {
            for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                if (entry.getValue().booleanValue()) {
                    Object obj = get(iIntValue);
                    if (!(obj instanceof String)) {
                        obj = null;
                    }
                    String str = (String) obj;
                    z2 = str != null && StringsJVM.isBlank(str);
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void addOptionalFields(View... views) {
        Intrinsics3.checkNotNullParameter(views, "views");
        for (View view : views) {
            this.requiredFieldIds.put(Integer.valueOf(view.getId()), Boolean.FALSE);
        }
    }

    public final void clear() {
        clear$default(this, false, 1, null);
    }

    public final void clear(boolean clearDefaults) {
        this.viewValuesEdited.clear();
        if (clearDefaults) {
            this.viewValues.clear();
        }
    }

    public final void configureSaveActionView(View saveActionView) {
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        AnonymousClass2 anonymousClass2 = AnonymousClass2.INSTANCE;
        if (saveActionView != null) {
            if (!hasAnythingChanged() || isAnyRequiredFieldBlank()) {
                anonymousClass1.invoke2(saveActionView);
            } else {
                anonymousClass2.invoke2(saveActionView);
            }
        }
    }

    public final <T> T getIfChanged(int id2) {
        if (hasChanged(id2)) {
            return (T) this.viewValuesEdited.get(Integer.valueOf(id2));
        }
        return null;
    }

    public final boolean hasChanged(int viewId) {
        if (this.viewValuesEdited.containsKey(Integer.valueOf(viewId))) {
            return !Intrinsics3.areEqual(this.viewValuesEdited.get(Integer.valueOf(viewId)), this.viewValues.get(Integer.valueOf(viewId)));
        }
        return false;
    }

    public final <T> void put(int id2, T value) {
        this.viewValuesEdited.put(Integer.valueOf(id2), value);
    }

    public final void setupTextWatcherWithSaveAction(AppFragment fragment, View saveAction, View... views) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Intrinsics3.checkNotNullParameter(views, "views");
        for (View view : views) {
            HashMap<Integer, Boolean> map = this.requiredFieldIds;
            Integer numValueOf = Integer.valueOf(view.getId());
            Boolean bool = this.requiredFieldIds.get(Integer.valueOf(view.getId()));
            if (bool == null) {
                bool = Boolean.TRUE;
            }
            Intrinsics3.checkNotNullExpressionValue(bool, "requiredFieldIds[view.id] ?: true");
            map.put(numValueOf, bool);
            StatefulViews2 statefulViews2 = new StatefulViews2(view, this, saveAction, fragment);
            StatefulViews3 statefulViews3 = new StatefulViews3(view, this, saveAction, fragment);
            if (view instanceof TextView) {
                TextWatcher4.addBindedTextWatcher((TextView) view, fragment, statefulViews2);
            } else if (view instanceof TextInputLayout) {
                ViewExtensions.addBindedTextWatcher((TextInputLayout) view, fragment, statefulViews2);
            } else {
                if (!(view instanceof CheckedSetting)) {
                    throw new UnsupportedOperationException(view + " must support using `TextWatcher`.");
                }
                ((CheckedSetting) view).setOnCheckedListener(new StatefulViews4(statefulViews3));
            }
        }
    }

    public final void setupUnsavedChangesConfirmation(AppFragment fragment) {
        FragmentOnBackPressedHandler fragmentOnBackPressedHandler;
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            Intrinsics3.checkNotNullExpressionValue(activity, "it");
            fragmentOnBackPressedHandler = new FragmentOnBackPressedHandler(activity, new StatefulViews5(this));
        } else {
            fragmentOnBackPressedHandler = null;
        }
        AppFragment.setOnBackPressed$default(fragment, new AnonymousClass1(fragmentOnBackPressedHandler), 0, 2, null);
    }

    public final <T> T get(int id2, T defaultValue) {
        this.viewValues.put(Integer.valueOf(id2), defaultValue);
        T t = (T) get(id2);
        return (!Intrinsics3.areEqual(this.requiredFieldIds.get(Integer.valueOf(id2)), Boolean.FALSE) && t == null) ? defaultValue : t;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StatefulViews(int... iArr) {
        this(_Arrays.toList(iArr));
        Intrinsics3.checkNotNullParameter(iArr, "ids");
    }

    public StatefulViews(Collection<? extends View> collection) {
        Intrinsics3.checkNotNullParameter(collection, "views");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((View) it.next()).getId()));
        }
        this((List<Integer>) arrayList);
    }
}
