package b.a.a;

import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.i.GuildVideoAtCapacityBinding;
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

/* compiled from: GuildVideoAtCapacityDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001d\u0010\n\u001a\u00020\u00058B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lb/a/a/m;", "Lcom/discord/app/AppDialog;", "", "onResume", "()V", "Lb/a/i/z;", "l", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lb/a/i/z;", "binding", "<init>", "k", "a", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: b.a.a.m, reason: use source file name */
/* loaded from: classes.dex */
public final class GuildVideoAtCapacityDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(GuildVideoAtCapacityDialog.class, "binding", "getBinding()Lcom/discord/databinding/GuildVideoAtCapacityBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* compiled from: GuildVideoAtCapacityDialog.kt */
    /* renamed from: b.a.a.m$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final void a(FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            new GuildVideoAtCapacityDialog().show(fragmentManager, GuildVideoAtCapacityDialog.class.getSimpleName());
        }
    }

    /* compiled from: GuildVideoAtCapacityDialog.kt */
    /* renamed from: b.a.a.m$b */
    public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<View, GuildVideoAtCapacityBinding> {
        public static final b j = new b();

        public b() {
            super(1, GuildVideoAtCapacityBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/GuildVideoAtCapacityBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public GuildVideoAtCapacityBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.guild_video_at_capacity_confirm;
            MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.guild_video_at_capacity_confirm);
            if (materialButton != null) {
                i = R.id.notice_header_container;
                LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.notice_header_container);
                if (linearLayout != null) {
                    return new GuildVideoAtCapacityBinding((LinearLayout) view2, materialButton, linearLayout);
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: GuildVideoAtCapacityDialog.kt */
    /* renamed from: b.a.a.m$c */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildVideoAtCapacityDialog.this.dismiss();
        }
    }

    public GuildVideoAtCapacityDialog() {
        super(R.layout.guild_video_at_capacity);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, b.j, null, 2, null);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        requireDialog().setCanceledOnTouchOutside(true);
        ((GuildVideoAtCapacityBinding) this.binding.getValue((Fragment) this, j[0])).f238b.setOnClickListener(new c());
    }
}
