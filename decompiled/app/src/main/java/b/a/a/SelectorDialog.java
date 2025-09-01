package b.a.a;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.DialogSimpleSelectorBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.DialogSimpleSelectorItemBinding;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.google.android.material.button.MaterialButton;
import d0.t._ArraysJvm;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: SelectorDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \u00192\u00020\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0018\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u000e\u001a\u00020\t8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR0\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lb/a/a/n;", "Lcom/discord/app/AppDialog;", "Landroid/view/View;", "view", "", "onViewBound", "(Landroid/view/View;)V", "onPause", "()V", "Lb/a/i/l;", "m", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "g", "()Lb/a/i/l;", "binding", "Lkotlin/Function1;", "", "l", "Lkotlin/jvm/functions/Function1;", "getOnSelectedListener", "()Lkotlin/jvm/functions/Function1;", "setOnSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "onSelectedListener", "<init>", "k", "a", "b", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: b.a.a.n, reason: use source file name */
/* loaded from: classes.dex */
public final class SelectorDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(SelectorDialog.class, "binding", "getBinding()Lcom/discord/databinding/DialogSimpleSelectorBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public Function1<? super Integer, Unit> onSelectedListener;

    /* renamed from: m, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* compiled from: SelectorDialog.kt */
    /* renamed from: b.a.a.n$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final SelectorDialog a(FragmentManager fragmentManager, CharSequence charSequence, CharSequence[] charSequenceArr, Function1<? super Integer, Unit> function1) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(charSequence, "title");
            Intrinsics3.checkNotNullParameter(charSequenceArr, "options");
            Intrinsics3.checkNotNullParameter(function1, "onSelectedListener");
            SelectorDialog selectorDialog = new SelectorDialog();
            Bundle bundle = new Bundle();
            bundle.putCharSequence("INTENT_DIALOG_TITLE", charSequence);
            bundle.putCharSequenceArray("INTENT_DIALOG_OPTIONS", charSequenceArr);
            selectorDialog.setArguments(bundle);
            selectorDialog.onSelectedListener = function1;
            selectorDialog.show(fragmentManager, Reflection2.getOrCreateKotlinClass(SelectorDialog.class).toString());
            return selectorDialog;
        }
    }

    /* compiled from: SelectorDialog.kt */
    /* renamed from: b.a.a.n$b */
    public final class b extends SimpleRecyclerAdapter.ViewHolder<CharSequence> {
        public final DialogSimpleSelectorItemBinding a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SelectorDialog f49b;

        /* JADX WARN: Illegal instructions before constructor call */
        public b(SelectorDialog selectorDialog, DialogSimpleSelectorItemBinding dialogSimpleSelectorItemBinding) {
            Intrinsics3.checkNotNullParameter(dialogSimpleSelectorItemBinding, "binding");
            this.f49b = selectorDialog;
            TextView textView = dialogSimpleSelectorItemBinding.a;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.root");
            super(textView);
            this.a = dialogSimpleSelectorItemBinding;
        }

        @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
        public void bind(CharSequence charSequence) {
            CharSequence charSequence2 = charSequence;
            Intrinsics3.checkNotNullParameter(charSequence2, "data");
            TextView textView = this.a.a;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.root");
            textView.setText(charSequence2);
            this.a.a.setOnClickListener(new SelectorDialog2(this));
        }
    }

    /* compiled from: SelectorDialog.kt */
    /* renamed from: b.a.a.n$c */
    public static final /* synthetic */ class c extends FunctionReferenceImpl implements Function1<View, DialogSimpleSelectorBinding> {
        public static final c j = new c();

        public c() {
            super(1, DialogSimpleSelectorBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/DialogSimpleSelectorBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public DialogSimpleSelectorBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.dialog_cancel;
            MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.dialog_cancel);
            if (materialButton != null) {
                i = R.id.dialog_selections;
                MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) view2.findViewById(R.id.dialog_selections);
                if (maxHeightRecyclerView != null) {
                    i = R.id.dialog_title;
                    TextView textView = (TextView) view2.findViewById(R.id.dialog_title);
                    if (textView != null) {
                        return new DialogSimpleSelectorBinding((LinearLayout) view2, materialButton, maxHeightRecyclerView, textView);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: SelectorDialog.kt */
    /* renamed from: b.a.a.n$d */
    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SelectorDialog.this.dismiss();
        }
    }

    /* compiled from: SelectorDialog.kt */
    /* renamed from: b.a.a.n$e */
    public static final class e extends Lambda implements Function2<LayoutInflater, ViewGroup, b> {
        public e() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public b invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            LayoutInflater layoutInflater2 = layoutInflater;
            ViewGroup viewGroup2 = viewGroup;
            Intrinsics3.checkNotNullParameter(layoutInflater2, "inflater");
            Intrinsics3.checkNotNullParameter(viewGroup2, "parent");
            DialogSimpleSelectorItemBinding dialogSimpleSelectorItemBindingA = DialogSimpleSelectorItemBinding.a(layoutInflater2, viewGroup2, false);
            Intrinsics3.checkNotNullExpressionValue(dialogSimpleSelectorItemBindingA, "DialogSimpleSelectorItem…(inflater, parent, false)");
            return new b(SelectorDialog.this, dialogSimpleSelectorItemBindingA);
        }
    }

    public SelectorDialog() {
        super(R.layout.dialog_simple_selector);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, c.j, null, 2, null);
    }

    public final DialogSimpleSelectorBinding g() {
        return (DialogSimpleSelectorBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = g().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.dialogTitle");
        textView.setText(getArgumentsOrDefault().getCharSequence("INTENT_DIALOG_TITLE", null));
        g().f149b.setOnClickListener(new d());
        CharSequence[] charSequenceArray = getArgumentsOrDefault().getCharSequenceArray("INTENT_DIALOG_OPTIONS");
        if (charSequenceArray != null) {
            MaxHeightRecyclerView maxHeightRecyclerView = g().c;
            Intrinsics3.checkNotNullExpressionValue(maxHeightRecyclerView, "binding.dialogSelections");
            maxHeightRecyclerView.setAdapter(new SimpleRecyclerAdapter(_ArraysJvm.asList(charSequenceArray), new e()));
            MaxHeightRecyclerView maxHeightRecyclerView2 = g().c;
            RecyclerView.Adapter adapter = maxHeightRecyclerView2.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            maxHeightRecyclerView2.setHasFixedSize(false);
            maxHeightRecyclerView2.setNestedScrollingEnabled(false);
            SimpleRecyclerAdapter.Companion companion = SimpleRecyclerAdapter.INSTANCE;
            MaxHeightRecyclerView maxHeightRecyclerView3 = g().c;
            Intrinsics3.checkNotNullExpressionValue(maxHeightRecyclerView3, "binding.dialogSelections");
            companion.addThemedDivider(maxHeightRecyclerView3);
        }
    }
}
