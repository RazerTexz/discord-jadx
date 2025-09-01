package b.a.a;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.i.CameraCapacityDialogBinding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: CameraCapacityDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001d\u0010\n\u001a\u00020\u00058B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lb/a/a/j;", "Lcom/discord/app/AppDialog;", "", "onResume", "()V", "Lb/a/i/e;", "l", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lb/a/i/e;", "binding", "<init>", "k", "a", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: b.a.a.j, reason: use source file name */
/* loaded from: classes.dex */
public final class CameraCapacityDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(CameraCapacityDialog.class, "binding", "getBinding()Lcom/discord/databinding/CameraCapacityDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* compiled from: CameraCapacityDialog.kt */
    /* renamed from: b.a.a.j$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final void a(FragmentManager fragmentManager, int i) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Bundle bundle = new Bundle();
            bundle.putInt("ARG_MAX_VIDEO_CHANNEL_USERS", i);
            CameraCapacityDialog cameraCapacityDialog = new CameraCapacityDialog();
            cameraCapacityDialog.setArguments(bundle);
            cameraCapacityDialog.show(fragmentManager, CameraCapacityDialog.class.getSimpleName());
        }
    }

    /* compiled from: CameraCapacityDialog.kt */
    /* renamed from: b.a.a.j$b */
    public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<View, CameraCapacityDialogBinding> {
        public static final b j = new b();

        public b() {
            super(1, CameraCapacityDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/CameraCapacityDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public CameraCapacityDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.camera_capacity_body;
            TextView textView = (TextView) view2.findViewById(R.id.camera_capacity_body);
            if (textView != null) {
                i = R.id.camera_capacity_confirm;
                MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.camera_capacity_confirm);
                if (materialButton != null) {
                    i = R.id.notice_header_container;
                    LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.notice_header_container);
                    if (linearLayout != null) {
                        return new CameraCapacityDialogBinding((LinearLayout) view2, textView, materialButton, linearLayout);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: CameraCapacityDialog.kt */
    /* renamed from: b.a.a.j$c */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            CameraCapacityDialog.this.dismiss();
        }
    }

    public CameraCapacityDialog() {
        super(R.layout.camera_capacity_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, b.j, null, 2, null);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        requireDialog().setCanceledOnTouchOutside(true);
        FragmentViewBindingDelegate fragmentViewBindingDelegate = this.binding;
        KProperty<?>[] kPropertyArr = j;
        ((CameraCapacityDialogBinding) fragmentViewBindingDelegate.getValue((Fragment) this, kPropertyArr[0])).c.setOnClickListener(new c());
        Bundle arguments = getArguments();
        Integer numValueOf = arguments != null ? Integer.valueOf(arguments.getInt("ARG_MAX_VIDEO_CHANNEL_USERS")) : null;
        TextView textView = ((CameraCapacityDialogBinding) this.binding.getValue((Fragment) this, kPropertyArr[0])).f102b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.cameraCapacityBody");
        textView.setText(FormatUtils.k(this, R.string.video_capacity_modal_body, new Object[]{String.valueOf(numValueOf)}, null, 4));
    }
}
