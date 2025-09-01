package b.a.a.f.a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.f.a.AudioOutputSelectionDialogViewModel2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.i.AudioOutputSelectionDialogBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import defpackage.k;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: AudioOutputSelectionDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0015\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u000e\u001a\u00020\t8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0014\u001a\u00020\u000f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lb/a/a/f/a/a;", "Lcom/discord/app/AppDialog;", "Landroid/view/View;", "view", "", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lb/a/a/f/a/d;", "m", "Lkotlin/Lazy;", "getViewModel", "()Lb/a/a/f/a/d;", "viewModel", "Lb/a/i/b;", "l", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "i", "()Lb/a/i/b;", "binding", "<init>", "k", "b", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: b.a.a.f.a.a, reason: use source file name */
/* loaded from: classes.dex */
public final class AudioOutputSelectionDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(AudioOutputSelectionDialog.class, "binding", "getBinding()Lcom/discord/databinding/AudioOutputSelectionDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* renamed from: m, reason: from kotlin metadata */
    public final Lazy viewModel;

    /* compiled from: java-style lambda group */
    /* renamed from: b.a.a.f.a.a$a */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        public a(int i, Object obj) {
            this.j = i;
            this.k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.j;
            if (i == 0) {
                AudioOutputSelectionDialog.h((AudioOutputSelectionDialog) this.k).j.selectOutputDevice(DiscordAudioManager.DeviceTypes.BLUETOOTH_HEADSET);
                AudioOutputSelectionDialog.g((AudioOutputSelectionDialog) this.k);
                return;
            }
            if (i == 1) {
                AudioOutputSelectionDialog.h((AudioOutputSelectionDialog) this.k).j.selectOutputDevice(DiscordAudioManager.DeviceTypes.SPEAKERPHONE);
                AudioOutputSelectionDialog.g((AudioOutputSelectionDialog) this.k);
            } else if (i == 2) {
                AudioOutputSelectionDialog.h((AudioOutputSelectionDialog) this.k).j.selectOutputDevice(DiscordAudioManager.DeviceTypes.WIRED_HEADSET);
                AudioOutputSelectionDialog.g((AudioOutputSelectionDialog) this.k);
            } else {
                if (i != 3) {
                    throw null;
                }
                AudioOutputSelectionDialog.h((AudioOutputSelectionDialog) this.k).j.selectOutputDevice(DiscordAudioManager.DeviceTypes.EARPIECE);
                AudioOutputSelectionDialog.g((AudioOutputSelectionDialog) this.k);
            }
        }
    }

    /* compiled from: AudioOutputSelectionDialog.kt */
    /* renamed from: b.a.a.f.a.a$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: AudioOutputSelectionDialog.kt */
    /* renamed from: b.a.a.f.a.a$c */
    public static final /* synthetic */ class c extends FunctionReferenceImpl implements Function1<View, AudioOutputSelectionDialogBinding> {
        public static final c j = new c();

        public c() {
            super(1, AudioOutputSelectionDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/AudioOutputSelectionDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public AudioOutputSelectionDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.audio_output_selection_bluetooth_radio;
            MaterialRadioButton materialRadioButton = (MaterialRadioButton) view2.findViewById(R.id.audio_output_selection_bluetooth_radio);
            if (materialRadioButton != null) {
                i = R.id.audio_output_selection_dialog_header;
                TextView textView = (TextView) view2.findViewById(R.id.audio_output_selection_dialog_header);
                if (textView != null) {
                    i = R.id.audio_output_selection_dialog_radio_group;
                    RadioGroup radioGroup = (RadioGroup) view2.findViewById(R.id.audio_output_selection_dialog_radio_group);
                    if (radioGroup != null) {
                        i = R.id.audio_output_selection_earpiece_radio;
                        MaterialRadioButton materialRadioButton2 = (MaterialRadioButton) view2.findViewById(R.id.audio_output_selection_earpiece_radio);
                        if (materialRadioButton2 != null) {
                            i = R.id.audio_output_selection_speaker_radio;
                            MaterialRadioButton materialRadioButton3 = (MaterialRadioButton) view2.findViewById(R.id.audio_output_selection_speaker_radio);
                            if (materialRadioButton3 != null) {
                                i = R.id.audio_output_selection_wired_radio;
                                MaterialRadioButton materialRadioButton4 = (MaterialRadioButton) view2.findViewById(R.id.audio_output_selection_wired_radio);
                                if (materialRadioButton4 != null) {
                                    return new AudioOutputSelectionDialogBinding((LinearLayout) view2, materialRadioButton, textView, radioGroup, materialRadioButton2, materialRadioButton3, materialRadioButton4);
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: AudioOutputSelectionDialog.kt */
    /* renamed from: b.a.a.f.a.a$d */
    public static final class d extends Lambda implements Function1<AudioOutputSelectionDialogViewModel2.a, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(AudioOutputSelectionDialogViewModel2.a aVar) {
            int id2;
            AudioOutputSelectionDialogViewModel2.a aVar2 = aVar;
            Intrinsics3.checkNotNullParameter(aVar2, "viewState");
            AudioOutputSelectionDialog audioOutputSelectionDialog = AudioOutputSelectionDialog.this;
            Objects.requireNonNull(audioOutputSelectionDialog);
            Intrinsics3.checkNotNullParameter(aVar2, "viewState");
            if (!(aVar2 instanceof AudioOutputSelectionDialogViewModel2.a.b) && (aVar2 instanceof AudioOutputSelectionDialogViewModel2.a.C0012a)) {
                AudioOutputSelectionDialogViewModel2.a.C0012a c0012a = (AudioOutputSelectionDialogViewModel2.a.C0012a) aVar2;
                int iOrdinal = c0012a.a.ordinal();
                if (iOrdinal == 2) {
                    MaterialRadioButton materialRadioButton = audioOutputSelectionDialog.i().e;
                    Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.audioOutputSelectionSpeakerRadio");
                    id2 = materialRadioButton.getId();
                } else if (iOrdinal == 3) {
                    MaterialRadioButton materialRadioButton2 = audioOutputSelectionDialog.i().f;
                    Intrinsics3.checkNotNullExpressionValue(materialRadioButton2, "binding.audioOutputSelectionWiredRadio");
                    id2 = materialRadioButton2.getId();
                } else if (iOrdinal == 4) {
                    MaterialRadioButton materialRadioButton3 = audioOutputSelectionDialog.i().d;
                    Intrinsics3.checkNotNullExpressionValue(materialRadioButton3, "binding.audioOutputSelectionEarpieceRadio");
                    id2 = materialRadioButton3.getId();
                } else if (iOrdinal == 5) {
                    MaterialRadioButton materialRadioButton4 = audioOutputSelectionDialog.i().f80b;
                    Intrinsics3.checkNotNullExpressionValue(materialRadioButton4, "binding.audioOutputSelectionBluetoothRadio");
                    id2 = materialRadioButton4.getId();
                }
                audioOutputSelectionDialog.i().c.check(id2);
                MaterialRadioButton materialRadioButton5 = audioOutputSelectionDialog.i().f80b;
                Intrinsics3.checkNotNullExpressionValue(materialRadioButton5, "binding.audioOutputSelectionBluetoothRadio");
                materialRadioButton5.setVisibility(c0012a.f48b ? 0 : 8);
                MaterialRadioButton materialRadioButton6 = audioOutputSelectionDialog.i().f80b;
                Intrinsics3.checkNotNullExpressionValue(materialRadioButton6, "binding.audioOutputSelectionBluetoothRadio");
                String string = c0012a.c;
                if (string == null) {
                    string = audioOutputSelectionDialog.getString(R.string.audio_devices_bluetooth);
                }
                materialRadioButton6.setText(string);
                MaterialRadioButton materialRadioButton7 = audioOutputSelectionDialog.i().e;
                Intrinsics3.checkNotNullExpressionValue(materialRadioButton7, "binding.audioOutputSelectionSpeakerRadio");
                materialRadioButton7.setVisibility(c0012a.d ? 0 : 8);
                MaterialRadioButton materialRadioButton8 = audioOutputSelectionDialog.i().f;
                Intrinsics3.checkNotNullExpressionValue(materialRadioButton8, "binding.audioOutputSelectionWiredRadio");
                materialRadioButton8.setVisibility(c0012a.e ? 0 : 8);
                MaterialRadioButton materialRadioButton9 = audioOutputSelectionDialog.i().d;
                Intrinsics3.checkNotNullExpressionValue(materialRadioButton9, "binding.audioOutputSelectionEarpieceRadio");
                materialRadioButton9.setVisibility(c0012a.f ? 0 : 8);
            }
            return Unit.a;
        }
    }

    /* compiled from: AudioOutputSelectionDialog.kt */
    /* renamed from: b.a.a.f.a.a$e */
    public static final class e extends Lambda implements Function0<AudioOutputSelectionDialogViewModel2> {
        public static final e j = new e();

        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AudioOutputSelectionDialogViewModel2 invoke() {
            return new AudioOutputSelectionDialogViewModel2(null, null, 3);
        }
    }

    public AudioOutputSelectionDialog() {
        super(R.layout.audio_output_selection_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, c.j, null, 2, null);
        e eVar = e.j;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(AudioOutputSelectionDialogViewModel2.class), new k(5, appViewModelDelegates3), new AppViewModelDelegates5(eVar));
    }

    public static final void g(AudioOutputSelectionDialog audioOutputSelectionDialog) {
        Objects.requireNonNull(audioOutputSelectionDialog);
        Observable<Long> observableD0 = Observable.d0(300L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable\n        .time…S, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, audioOutputSelectionDialog, null, 2, null), AudioOutputSelectionDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AudioOutputSelectionDialog2(audioOutputSelectionDialog), 62, (Object) null);
    }

    public static final AudioOutputSelectionDialogViewModel2 h(AudioOutputSelectionDialog audioOutputSelectionDialog) {
        return (AudioOutputSelectionDialogViewModel2) audioOutputSelectionDialog.viewModel.getValue();
    }

    public final AudioOutputSelectionDialogBinding i() {
        return (AudioOutputSelectionDialogBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        int themedColor = ColorCompat.getThemedColor(view, R.attr.colorInteractiveNormal);
        MaterialRadioButton materialRadioButton = i().f80b;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.audioOutputSelectionBluetoothRadio");
        ColorCompat2.setDrawableColor(materialRadioButton, themedColor);
        MaterialRadioButton materialRadioButton2 = i().e;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton2, "binding.audioOutputSelectionSpeakerRadio");
        ColorCompat2.setDrawableColor(materialRadioButton2, themedColor);
        MaterialRadioButton materialRadioButton3 = i().f;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton3, "binding.audioOutputSelectionWiredRadio");
        ColorCompat2.setDrawableColor(materialRadioButton3, themedColor);
        MaterialRadioButton materialRadioButton4 = i().d;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton4, "binding.audioOutputSelectionEarpieceRadio");
        ColorCompat2.setDrawableColor(materialRadioButton4, themedColor);
        i().f80b.setOnClickListener(new a(0, this));
        i().e.setOnClickListener(new a(1, this));
        i().f.setOnClickListener(new a(2, this));
        i().d.setOnClickListener(new a(3, this));
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(((AudioOutputSelectionDialogViewModel2) this.viewModel.getValue()).observeViewState(), this, null, 2, null), AudioOutputSelectionDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new d(), 62, (Object) null);
    }
}
