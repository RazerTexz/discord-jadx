package b.a.a;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.i.DialogDatePickerBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.utilities.birthday.BirthdayHelper;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: DatePickerDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R0\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0018\u001a\u00020\u00138B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lb/a/a/k;", "Lcom/discord/app/AppDialog;", "", "onViewBoundOrOnResume", "()V", "onPause", "Lkotlin/Function1;", "", "l", "Lkotlin/jvm/functions/Function1;", "getOnDatePicked", "()Lkotlin/jvm/functions/Function1;", "setOnDatePicked", "(Lkotlin/jvm/functions/Function1;)V", "onDatePicked", "", "n", "Z", "datePicked", "Lb/a/i/k;", "o", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "g", "()Lb/a/i/k;", "binding", "m", "J", "selectedDate", "<init>", "k", "a", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: b.a.a.k, reason: use source file name */
/* loaded from: classes.dex */
public final class DatePickerDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(DatePickerDialog.class, "binding", "getBinding()Lcom/discord/databinding/DialogDatePickerBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public Function1<? super Long, Unit> onDatePicked;

    /* renamed from: m, reason: from kotlin metadata */
    public long selectedDate;

    /* renamed from: n, reason: from kotlin metadata */
    public boolean datePicked;

    /* renamed from: o, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* compiled from: DatePickerDialog.kt */
    /* renamed from: b.a.a.k$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final DatePickerDialog a(FragmentManager fragmentManager, CharSequence charSequence, long j, long j2) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(charSequence, "label");
            DatePickerDialog datePickerDialog = new DatePickerDialog();
            Bundle bundle = new Bundle();
            bundle.putCharSequence("label", charSequence);
            bundle.putLong("initial_date", j);
            bundle.putLong("max_date", j2);
            datePickerDialog.setArguments(bundle);
            datePickerDialog.show(fragmentManager, DatePickerDialog.class.getName());
            return datePickerDialog;
        }
    }

    /* compiled from: DatePickerDialog.kt */
    /* renamed from: b.a.a.k$b */
    public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<View, DialogDatePickerBinding> {
        public static final b j = new b();

        public b() {
            super(1, DialogDatePickerBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/DialogDatePickerBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public DialogDatePickerBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.dialog_date_picker_done;
            MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.dialog_date_picker_done);
            if (materialButton != null) {
                i = R.id.dialog_date_picker_input;
                DatePicker datePicker = (DatePicker) view2.findViewById(R.id.dialog_date_picker_input);
                if (datePicker != null) {
                    i = R.id.dialog_date_picker_title;
                    TextView textView = (TextView) view2.findViewById(R.id.dialog_date_picker_title);
                    if (textView != null) {
                        return new DialogDatePickerBinding((LinearLayout) view2, materialButton, datePicker, textView);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: DatePickerDialog.kt */
    /* renamed from: b.a.a.k$c */
    public static final class c implements DatePicker.OnDateChangedListener {
        public c() {
        }

        @Override // android.widget.DatePicker.OnDateChangedListener
        public final void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(i, i2, i3);
            DatePickerDialog datePickerDialog = DatePickerDialog.this;
            Intrinsics3.checkNotNullExpressionValue(calendar, "cal");
            datePickerDialog.selectedDate = calendar.getTimeInMillis();
            DatePickerDialog datePickerDialog2 = DatePickerDialog.this;
            datePickerDialog2.datePicked = true;
            Function1<? super Long, Unit> function1 = datePickerDialog2.onDatePicked;
            if (function1 != null) {
                function1.invoke(Long.valueOf(datePickerDialog2.selectedDate));
            }
        }
    }

    /* compiled from: DatePickerDialog.kt */
    /* renamed from: b.a.a.k$d */
    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1<? super Long, Unit> function1;
            DatePickerDialog datePickerDialog = DatePickerDialog.this;
            if (datePickerDialog.datePicked && (function1 = datePickerDialog.onDatePicked) != null) {
                function1.invoke(Long.valueOf(datePickerDialog.selectedDate));
            }
            DatePickerDialog.this.dismiss();
        }
    }

    public DatePickerDialog() {
        super(R.layout.dialog_date_picker);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, b.j, null, 2, null);
    }

    public final DialogDatePickerBinding g() {
        return (DialogDatePickerBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        g().c.clearFocus();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        CharSequence charSequence;
        super.onViewBoundOrOnResume();
        TextView textView = g().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.dialogDatePickerTitle");
        Bundle arguments = getArguments();
        if (arguments == null || (charSequence = arguments.getCharSequence("label")) == null) {
            charSequence = "";
        }
        textView.setText(charSequence);
        DatePicker datePicker = g().c;
        Intrinsics3.checkNotNullExpressionValue(datePicker, "binding.dialogDatePickerInput");
        Bundle arguments2 = getArguments();
        datePicker.setMaxDate(arguments2 != null ? arguments2.getLong("max_date") : 0L);
        DatePicker datePicker2 = g().c;
        Intrinsics3.checkNotNullExpressionValue(datePicker2, "binding.dialogDatePickerInput");
        datePicker2.setMinDate(BirthdayHelper.INSTANCE.subtractYearsFromToday(150));
        Bundle arguments3 = getArguments();
        this.selectedDate = arguments3 != null ? arguments3.getLong("initial_date") : 0L;
        if (this.onDatePicked == null) {
            dismiss();
        }
        Calendar calendar = Calendar.getInstance();
        Intrinsics3.checkNotNullExpressionValue(calendar, "calendar");
        calendar.setTimeInMillis(this.selectedDate);
        g().c.init(calendar.get(1), calendar.get(2), calendar.get(5), new c());
        g().f143b.setOnClickListener(new d());
    }
}
