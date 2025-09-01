package com.discord.widgets.botuikit;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.botuikit.ActionRowComponent;
import com.discord.api.botuikit.TextComponent;
import com.discord.api.botuikit.TextComponent2;
import com.discord.api.interaction.InteractionModalCreate;
import com.discord.app.AppFragment;
import com.discord.databinding.BotUikitTextInputBinding;
import com.discord.databinding.ViewInteractionModalBinding;
import com.discord.stores.StoreApplicationCommandsKt;
import com.discord.stores.StoreApplicationInteractions;
import com.discord.stores.StoreStream;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.t._CollectionsJvm;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: ModalComponent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u0011\u0012\b\b\u0003\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u000e\u001a\u00020\t8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0014\u001a\u00020\u000f8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/botuikit/ModalComponent;", "Lcom/discord/app/AppFragment;", "Landroid/view/View;", "view", "", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/databinding/ViewInteractionModalBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/ViewInteractionModalBinding;", "binding", "Lcom/discord/widgets/botuikit/ModalComponent$Options;", "args$delegate", "Lkotlin/Lazy;", "getArgs", "()Lcom/discord/widgets/botuikit/ModalComponent$Options;", "args", "", "sentNonce", "Ljava/lang/String;", "", "contentResId", "<init>", "(I)V", "Companion", "Options", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ModalComponent extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(ModalComponent.class, "binding", "getBinding()Lcom/discord/databinding/ViewInteractionModalBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_OPTIONS = "extra_options";

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private String sentNonce;

    /* compiled from: ModalComponent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/botuikit/ModalComponent$Companion;", "", "Landroid/content/Context;", "context", "Lcom/discord/widgets/botuikit/ModalComponent$Options;", "options", "", "show", "(Landroid/content/Context;Lcom/discord/widgets/botuikit/ModalComponent$Options;)V", "", "EXTRA_OPTIONS", "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, Options options) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(options, "options");
            Intent intent = new Intent();
            intent.putExtra("extra_options", options);
            AppScreen2.d(context, ModalComponent.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ModalComponent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/botuikit/ModalComponent$Options;", "Landroid/os/Parcelable;", "Lcom/discord/api/interaction/InteractionModalCreate;", "component1", "()Lcom/discord/api/interaction/InteractionModalCreate;", "modal", "copy", "(Lcom/discord/api/interaction/InteractionModalCreate;)Lcom/discord/widgets/botuikit/ModalComponent$Options;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/discord/api/interaction/InteractionModalCreate;", "getModal", "<init>", "(Lcom/discord/api/interaction/InteractionModalCreate;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Options implements Parcelable {
        public static final Parcelable.Creator<Options> CREATOR = new Creator();
        private final InteractionModalCreate modal;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Options> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Options createFromParcel(Parcel parcel) {
                Intrinsics3.checkNotNullParameter(parcel, "in");
                return new Options((InteractionModalCreate) parcel.readSerializable());
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Options createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Options[] newArray(int i) {
                return new Options[i];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Options[] newArray(int i) {
                return newArray(i);
            }
        }

        public Options(InteractionModalCreate interactionModalCreate) {
            Intrinsics3.checkNotNullParameter(interactionModalCreate, "modal");
            this.modal = interactionModalCreate;
        }

        public static /* synthetic */ Options copy$default(Options options, InteractionModalCreate interactionModalCreate, int i, Object obj) {
            if ((i & 1) != 0) {
                interactionModalCreate = options.modal;
            }
            return options.copy(interactionModalCreate);
        }

        /* renamed from: component1, reason: from getter */
        public final InteractionModalCreate getModal() {
            return this.modal;
        }

        public final Options copy(InteractionModalCreate modal) {
            Intrinsics3.checkNotNullParameter(modal, "modal");
            return new Options(modal);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Options) && Intrinsics3.areEqual(this.modal, ((Options) other).modal);
            }
            return true;
        }

        public final InteractionModalCreate getModal() {
            return this.modal;
        }

        public int hashCode() {
            InteractionModalCreate interactionModalCreate = this.modal;
            if (interactionModalCreate != null) {
                return interactionModalCreate.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Options(modal=");
            sbU.append(this.modal);
            sbU.append(")");
            return sbU.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            parcel.writeSerializable(this.modal);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            StoreApplicationInteractions.SentInteractionState.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[StoreApplicationInteractions.SentInteractionState.SUCCESS.ordinal()] = 1;
            iArr[StoreApplicationInteractions.SentInteractionState.FAILURE.ordinal()] = 2;
        }
    }

    /* compiled from: ModalComponent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.botuikit.ModalComponent$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = ModalComponent.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: ModalComponent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.botuikit.ModalComponent$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ List $components;
        public final /* synthetic */ View $view;

        /* compiled from: ModalComponent.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "nonce", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.botuikit.ModalComponent$onViewBound$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C02382 extends Lambda implements Function1<String, Unit> {
            public C02382() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Intrinsics3.checkNotNullParameter(str, "nonce");
                ModalComponent.access$setSentNonce$p(ModalComponent.this, str);
            }
        }

        /* compiled from: ModalComponent.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.botuikit.ModalComponent$onViewBound$2$3, reason: invalid class name */
        public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {

            /* compiled from: ModalComponent.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.widgets.botuikit.ModalComponent$onViewBound$2$3$1, reason: invalid class name */
            public static final class AnonymousClass1 implements Runnable {
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ModalComponent.access$setSentNonce$p(ModalComponent.this, null);
                    LinearLayout linearLayout = ModalComponent.access$getBinding$p(ModalComponent.this).d;
                    Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.error");
                    linearLayout.setVisibility(0);
                    MaterialButton materialButton = ModalComponent.access$getBinding$p(ModalComponent.this).f;
                    Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.submit");
                    materialButton.setEnabled(true);
                }
            }

            public AnonymousClass3() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass2.this.$view.post(new AnonymousClass1());
            }
        }

        public AnonymousClass2(List list, View view) {
            this.$components = list;
            this.$view = view;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ArrayList arrayList = new ArrayList();
            boolean z2 = true;
            for (Tuples2 tuples2 : this.$components) {
                TextComponent textComponent = (TextComponent) tuples2.component1();
                BotUikitTextInputBinding botUikitTextInputBinding = (BotUikitTextInputBinding) tuples2.component2();
                TextInputEditText textInputEditText = botUikitTextInputBinding.f2089b;
                Intrinsics3.checkNotNullExpressionValue(textInputEditText, "text.editText");
                String strValueOf = String.valueOf(textInputEditText.getText());
                if (strValueOf.length() == 0) {
                    if (Intrinsics3.areEqual(textComponent.getRequired(), Boolean.TRUE)) {
                        TextInputLayout textInputLayout = botUikitTextInputBinding.d;
                        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "text.layout");
                        textInputLayout.setError(FormatUtils.k(ModalComponent.this, R.string.form_length_error, new Object[]{Integer.valueOf(textComponent.getMinLength()), Integer.valueOf(textComponent.getMaxLength())}, null, 4));
                        z2 = false;
                    }
                } else if (strValueOf.length() < textComponent.getMinLength() || strValueOf.length() > textComponent.getMaxLength()) {
                    TextInputLayout textInputLayout2 = botUikitTextInputBinding.d;
                    Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "text.layout");
                    textInputLayout2.setError(FormatUtils.k(ModalComponent.this, R.string.form_length_error, new Object[]{Integer.valueOf(textComponent.getMinLength()), Integer.valueOf(textComponent.getMaxLength())}, null, 4));
                    z2 = false;
                }
                arrayList.add(new Tuples2(textComponent.getCustomId(), strValueOf));
            }
            if (z2) {
                ModalComponent.access$setSentNonce$p(ModalComponent.this, null);
                LinearLayout linearLayout = ModalComponent.access$getBinding$p(ModalComponent.this).d;
                Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.error");
                linearLayout.setVisibility(8);
                MaterialButton materialButton = ModalComponent.access$getBinding$p(ModalComponent.this).f;
                Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.submit");
                materialButton.setEnabled(false);
                StoreStream.INSTANCE.getInteractions().sendModalInteraction(ModalComponent.this.getArgs().getModal(), arrayList, new C02382(), new AnonymousClass3());
            }
        }
    }

    /* compiled from: ModalComponent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "Lcom/discord/stores/StoreApplicationInteractions$SentInteraction;", "sentInteractions", "", "invoke", "(Ljava/util/Map;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.botuikit.ModalComponent$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Map<String, ? extends StoreApplicationInteractions.SentInteraction>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends StoreApplicationInteractions.SentInteraction> map) {
            invoke2((Map<String, StoreApplicationInteractions.SentInteraction>) map);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Map<String, StoreApplicationInteractions.SentInteraction> map) {
            StoreApplicationInteractions.SentInteraction sentInteraction;
            FragmentActivity activity;
            Intrinsics3.checkNotNullParameter(map, "sentInteractions");
            String strAccess$getSentNonce$p = ModalComponent.access$getSentNonce$p(ModalComponent.this);
            if (strAccess$getSentNonce$p == null || (sentInteraction = map.get(strAccess$getSentNonce$p)) == null) {
                return;
            }
            int iOrdinal = sentInteraction.getState().ordinal();
            if (iOrdinal != 1) {
                if (iOrdinal == 2 && (activity = ModalComponent.this.getActivity()) != null) {
                    activity.finish();
                    return;
                }
                return;
            }
            ModalComponent.access$setSentNonce$p(ModalComponent.this, null);
            LinearLayout linearLayout = ModalComponent.access$getBinding$p(ModalComponent.this).d;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.error");
            linearLayout.setVisibility(0);
            MaterialButton materialButton = ModalComponent.access$getBinding$p(ModalComponent.this).f;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.submit");
            materialButton.setEnabled(true);
        }
    }

    public ModalComponent() {
        this(0, 1, null);
    }

    public ModalComponent(@LayoutRes int i) {
        super(i);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, ModalComponent2.INSTANCE, null, 2, null);
        this.args = LazyJVM.lazy(new ModalComponent$$special$$inlined$args$1(this, "extra_options"));
    }

    public static final /* synthetic */ ViewInteractionModalBinding access$getBinding$p(ModalComponent modalComponent) {
        return modalComponent.getBinding();
    }

    public static final /* synthetic */ String access$getSentNonce$p(ModalComponent modalComponent) {
        return modalComponent.sentNonce;
    }

    public static final /* synthetic */ void access$setSentNonce$p(ModalComponent modalComponent, String str) {
        modalComponent.sentNonce = str;
    }

    private final ViewInteractionModalBinding getBinding() {
        return (ViewInteractionModalBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public final Options getArgs() {
        return (Options) this.args.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.title");
        textView.setText(getArgs().getModal().getTitle());
        SimpleDraweeView simpleDraweeView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.icon");
        simpleDraweeView.setContentDescription(getArgs().getModal().getApplication().getName());
        SimpleDraweeView simpleDraweeView2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.icon");
        IconUtils.setApplicationIcon(simpleDraweeView2, StoreApplicationCommandsKt.toDomainApplication(getArgs().getModal().getApplication()));
        TextView textView2 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.warning");
        FormatUtils.n(textView2, R.string.interaction_form_submission_application, new Object[]{getArgs().getModal().getApplication().getName()}, null, 4);
        List listFilterIsInstance = _CollectionsJvm.filterIsInstance(getArgs().getModal().b(), ActionRowComponent.class);
        ArrayList arrayList = new ArrayList();
        Iterator it = listFilterIsInstance.iterator();
        while (it.hasNext()) {
            Object orNull = _Collections.getOrNull(((ActionRowComponent) it.next()).b(), 0);
            if (!(orNull instanceof TextComponent)) {
                orNull = null;
            }
            TextComponent textComponent = (TextComponent) orNull;
            if (textComponent != null) {
                arrayList.add(textComponent);
            }
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            TextComponent textComponent2 = (TextComponent) it2.next();
            View viewInflate = LayoutInflater.from(requireContext()).inflate(R.layout.bot_uikit_text_input, (ViewGroup) null, false);
            int i = R.id.edit_text;
            TextInputEditText textInputEditText = (TextInputEditText) viewInflate.findViewById(R.id.edit_text);
            if (textInputEditText != null) {
                i = R.id.label;
                TextView textView3 = (TextView) viewInflate.findViewById(R.id.label);
                if (textView3 != null) {
                    i = R.id.layout;
                    TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R.id.layout);
                    if (textInputLayout != null) {
                        LinearLayout linearLayout = (LinearLayout) viewInflate;
                        BotUikitTextInputBinding botUikitTextInputBinding = new BotUikitTextInputBinding(linearLayout, textInputEditText, textView3, textInputLayout);
                        Intrinsics3.checkNotNullExpressionValue(botUikitTextInputBinding, "BotUikitTextInputBinding…r.from(requireContext()))");
                        Intrinsics3.checkNotNullExpressionValue(textView3, "textInput.label");
                        textView3.setText(textComponent2.getLabel());
                        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "textInput.layout");
                        textInputLayout.setCounterMaxLength(textComponent2.getMaxLength());
                        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "textInput.layout");
                        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new ModalComponent3(botUikitTextInputBinding));
                        textInputEditText.setText(textComponent2.getValue());
                        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "textInput.editText");
                        textInputEditText.setHint(textComponent2.getPlaceholder());
                        if (textComponent2.getStyle() == TextComponent2.PARAGRAPH) {
                            Intrinsics3.checkNotNullExpressionValue(textInputEditText, "textInput.editText");
                            textInputEditText.setMaxLines(5);
                            Intrinsics3.checkNotNullExpressionValue(textInputEditText, "textInput.editText");
                            textInputEditText.setInputType(131073);
                            Intrinsics3.checkNotNullExpressionValue(textInputEditText, "textInput.editText");
                            textInputEditText.setMinHeight(DimenUtils.dpToPixels(96));
                        } else {
                            Intrinsics3.checkNotNullExpressionValue(textInputEditText, "textInput.editText");
                            textInputEditText.setMaxLines(1);
                            Intrinsics3.checkNotNullExpressionValue(textInputEditText, "textInput.editText");
                            textInputEditText.setInputType(1);
                        }
                        getBinding().c.addView(linearLayout);
                        arrayList2.add(new Tuples2(textComponent2, botUikitTextInputBinding));
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        getBinding().f2200b.setOnClickListener(new AnonymousClass1());
        getBinding().f.setOnClickListener(new AnonymousClass2(arrayList2, view));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getInteractions().observeSentInteractions(), this, null, 2, null), ModalComponent.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    public /* synthetic */ ModalComponent(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? R.layout.view_interaction_modal : i);
    }
}
