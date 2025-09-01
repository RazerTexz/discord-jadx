package com.discord.widgets.voice.call;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.DiscordConnectService;
import com.discord.databinding.WidgetVoiceCallIncomingBinding;
import com.discord.models.user.User;
import com.discord.stores.StoreCalls;
import com.discord.stores.StoreMediaEngine;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.media.AppSound;
import com.discord.utilities.media.AppSoundManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.user.calls.PrivateCallLauncher;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.model.CallModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Func0;

/* compiled from: WidgetVoiceCallIncoming.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001:\u0002\u001f B\u0007¢\u0006\u0004\b\u001e\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000e\u0010\bJ\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0016\u001a\u00020\u00042\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014H\u0015¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001d\u001a\u00020\u00188B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/discord/widgets/voice/call/WidgetVoiceCallIncoming;", "Lcom/discord/app/AppFragment;", "Landroid/view/View;", "view", "", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "onStop", "Lcom/discord/widgets/voice/call/WidgetVoiceCallIncoming$Model;", "model", "configureUI", "(Lcom/discord/widgets/voice/call/WidgetVoiceCallIncoming$Model;)V", "onEmptyCallModel", "", "useVideo", "onConnect", "(Lcom/discord/widgets/voice/call/WidgetVoiceCallIncoming$Model;Z)V", "", "Lcom/discord/primitives/ChannelId;", "channelId", "onDecline", "(J)V", "Lcom/discord/databinding/WidgetVoiceCallIncomingBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetVoiceCallIncomingBinding;", "binding", "<init>", ExifInterface.TAG_MODEL, "SystemCallIncoming", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public class WidgetVoiceCallIncoming extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetVoiceCallIncoming.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceCallIncomingBinding;", 0)};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetVoiceCallIncoming.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\r\b\u0084\b\u0018\u0000 &2\u00020\u0001:\u0001&B%\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000bJ\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001d\u001a\u00060\u0019j\u0002`\u001a8F@\u0006¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b#\u0010\u000b¨\u0006'"}, d2 = {"Lcom/discord/widgets/voice/call/WidgetVoiceCallIncoming$Model;", "", "Lcom/discord/widgets/voice/model/CallModel;", "component1", "()Lcom/discord/widgets/voice/model/CallModel;", "", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "component2", "()Ljava/util/List;", "", "component3", "()I", "callModel", "privateCallUserListItems", "numIncomingCalls", "copy", "(Lcom/discord/widgets/voice/model/CallModel;Ljava/util/List;I)Lcom/discord/widgets/voice/call/WidgetVoiceCallIncoming$Model;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Lcom/discord/primitives/ChannelId;", "getChannelId", "()J", "channelId", "Ljava/util/List;", "getPrivateCallUserListItems", "Lcom/discord/widgets/voice/model/CallModel;", "getCallModel", "I", "getNumIncomingCalls", "<init>", "(Lcom/discord/widgets/voice/model/CallModel;Ljava/util/List;I)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final CallModel callModel;
        private final int numIncomingCalls;
        private final List<StoreVoiceParticipants.VoiceUser> privateCallUserListItems;

        /* compiled from: WidgetVoiceCallIncoming.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/discord/widgets/voice/call/WidgetVoiceCallIncoming$Model$Companion;", "", "Lrx/Observable;", "Lcom/discord/widgets/voice/call/WidgetVoiceCallIncoming$Model;", "get", "()Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get() {
                Observable<R> observableY = StoreStream.INSTANCE.getCallsIncoming().observeIncoming().Y(WidgetVoiceCallIncoming2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n            …          }\n            }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(CallModel callModel, List<StoreVoiceParticipants.VoiceUser> list, int i) {
            Intrinsics3.checkNotNullParameter(callModel, "callModel");
            Intrinsics3.checkNotNullParameter(list, "privateCallUserListItems");
            this.callModel = callModel;
            this.privateCallUserListItems = list;
            this.numIncomingCalls = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, CallModel callModel, List list, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                callModel = model.callModel;
            }
            if ((i2 & 2) != 0) {
                list = model.privateCallUserListItems;
            }
            if ((i2 & 4) != 0) {
                i = model.numIncomingCalls;
            }
            return model.copy(callModel, list, i);
        }

        /* renamed from: component1, reason: from getter */
        public final CallModel getCallModel() {
            return this.callModel;
        }

        public final List<StoreVoiceParticipants.VoiceUser> component2() {
            return this.privateCallUserListItems;
        }

        /* renamed from: component3, reason: from getter */
        public final int getNumIncomingCalls() {
            return this.numIncomingCalls;
        }

        public final Model copy(CallModel callModel, List<StoreVoiceParticipants.VoiceUser> privateCallUserListItems, int numIncomingCalls) {
            Intrinsics3.checkNotNullParameter(callModel, "callModel");
            Intrinsics3.checkNotNullParameter(privateCallUserListItems, "privateCallUserListItems");
            return new Model(callModel, privateCallUserListItems, numIncomingCalls);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.callModel, model.callModel) && Intrinsics3.areEqual(this.privateCallUserListItems, model.privateCallUserListItems) && this.numIncomingCalls == model.numIncomingCalls;
        }

        public final CallModel getCallModel() {
            return this.callModel;
        }

        public final long getChannelId() {
            return this.callModel.getChannel().getId();
        }

        public final int getNumIncomingCalls() {
            return this.numIncomingCalls;
        }

        public final List<StoreVoiceParticipants.VoiceUser> getPrivateCallUserListItems() {
            return this.privateCallUserListItems;
        }

        public int hashCode() {
            CallModel callModel = this.callModel;
            int iHashCode = (callModel != null ? callModel.hashCode() : 0) * 31;
            List<StoreVoiceParticipants.VoiceUser> list = this.privateCallUserListItems;
            return ((iHashCode + (list != null ? list.hashCode() : 0)) * 31) + this.numIncomingCalls;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(callModel=");
            sbU.append(this.callModel);
            sbU.append(", privateCallUserListItems=");
            sbU.append(this.privateCallUserListItems);
            sbU.append(", numIncomingCalls=");
            return outline.B(sbU, this.numIncomingCalls, ")");
        }
    }

    /* compiled from: WidgetVoiceCallIncoming.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u000eJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0012\u001a\u00020\u00062\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/voice/call/WidgetVoiceCallIncoming$SystemCallIncoming;", "Lcom/discord/widgets/voice/call/WidgetVoiceCallIncoming;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/discord/widgets/voice/call/WidgetVoiceCallIncoming$Model;", "model", "configureUI", "(Lcom/discord/widgets/voice/call/WidgetVoiceCallIncoming$Model;)V", "onEmptyCallModel", "()V", "", "Lcom/discord/primitives/ChannelId;", "channelId", "onDecline", "(J)V", "", "useVideo", "onConnect", "(Lcom/discord/widgets/voice/call/WidgetVoiceCallIncoming$Model;Z)V", "Ljava/util/concurrent/atomic/AtomicLong;", "cachedChannelId", "Ljava/util/concurrent/atomic/AtomicLong;", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class SystemCallIncoming extends WidgetVoiceCallIncoming {
        private AtomicLong cachedChannelId = new AtomicLong(0);

        @Override // com.discord.widgets.voice.call.WidgetVoiceCallIncoming
        public void configureUI(Model model) {
            if ((model != null ? Long.valueOf(model.getChannelId()) : null) != null) {
                this.cachedChannelId.set(model.getChannelId());
            }
            super.configureUI(model);
        }

        @Override // com.discord.widgets.voice.call.WidgetVoiceCallIncoming
        public void onConnect(Model model, boolean useVideo) {
            Intrinsics3.checkNotNullParameter(model, "model");
            NotificationClient.clear$default(NotificationClient.INSTANCE, model.getChannelId(), requireContext(), false, 4, null);
            DiscordConnectService.INSTANCE.b(requireContext(), model.getChannelId());
            WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, requireContext(), model.getChannelId(), false, null, null, 28, null);
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
            }
        }

        @Override // com.discord.widgets.voice.call.WidgetVoiceCallIncoming
        public void onDecline(long channelId) {
            super.onDecline(channelId);
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
            }
        }

        @Override // com.discord.widgets.voice.call.WidgetVoiceCallIncoming
        public void onEmptyCallModel() {
            long j = this.cachedChannelId.get();
            if (j == 0) {
                return;
            }
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
            }
            NotificationClient.clear$default(NotificationClient.INSTANCE, j, requireContext(), false, 4, null);
        }

        @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
        public void onViewCreated(View view, Bundle savedInstanceState) {
            Intrinsics3.checkNotNullParameter(view, "view");
            super.onViewCreated(view, savedInstanceState);
            Observable<Long> observableD0 = Observable.d0(15L, TimeUnit.SECONDS);
            Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable.timer(15, TimeUnit.SECONDS)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), SystemCallIncoming.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetVoiceCallIncoming3(this), 62, (Object) null);
        }
    }

    /* compiled from: WidgetVoiceCallIncoming.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "()Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1<R> implements Func0<Boolean> {
        public final /* synthetic */ Model $model;

        public AnonymousClass1(Model model) {
            this.$model = model;
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            WidgetVoiceCallIncoming.this.onDecline(this.$model.getChannelId());
            return Boolean.TRUE;
        }
    }

    /* compiled from: WidgetVoiceCallIncoming.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass2(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceCallIncoming.this.onConnect(this.$model, true);
        }
    }

    /* compiled from: WidgetVoiceCallIncoming.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass3(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceCallIncoming.this.onConnect(this.$model, false);
        }
    }

    /* compiled from: WidgetVoiceCallIncoming.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass4(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceCallIncoming.this.onDecline(this.$model.getChannelId());
        }
    }

    /* compiled from: WidgetVoiceCallIncoming.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "Landroidx/core/view/WindowInsetsCompat;", "insets", "onApplyWindowInsets", "(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements OnApplyWindowInsetsListener {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }
    }

    /* compiled from: WidgetVoiceCallIncoming.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/voice/call/WidgetVoiceCallIncoming$Model;", "p1", "", "invoke", "(Lcom/discord/widgets/voice/call/WidgetVoiceCallIncoming$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetVoiceCallIncoming widgetVoiceCallIncoming) {
            super(1, widgetVoiceCallIncoming, WidgetVoiceCallIncoming.class, "configureUI", "configureUI(Lcom/discord/widgets/voice/call/WidgetVoiceCallIncoming$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            ((WidgetVoiceCallIncoming) this.receiver).configureUI(model);
        }
    }

    public WidgetVoiceCallIncoming() {
        super(R.layout.widget_voice_call_incoming);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetVoiceCallIncoming4.INSTANCE, null, 2, null);
    }

    private final WidgetVoiceCallIncomingBinding getBinding() {
        return (WidgetVoiceCallIncomingBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public void configureUI(Model model) {
        User user;
        String username = null;
        if ((model != null ? model.getCallModel() : null) == null) {
            onEmptyCallModel();
            return;
        }
        CallModel callModel = model.getCallModel();
        List<StoreVoiceParticipants.VoiceUser> listComponent2 = model.component2();
        AppFragment.setOnBackPressed$default(this, new AnonymousClass1(model), 0, 2, null);
        AppSoundManager.Provider.INSTANCE.get().play(AppSound.INSTANCE.getSOUND_CALL_RINGING());
        TextView textView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.incomingCallStatusPrimary");
        if (ChannelUtils.z(callModel.getChannel())) {
            username = ChannelUtils.c(callModel.getChannel());
        } else {
            StoreVoiceParticipants.VoiceUser dmRecipient = callModel.getDmRecipient();
            if (dmRecipient != null && (user = dmRecipient.getUser()) != null) {
                username = user.getUsername();
            }
        }
        textView.setText(username);
        getBinding().h.setText(callModel.getIsVideoCall() ? R.string.incoming_video_call : R.string.incoming_call);
        getBinding().i.configure(listComponent2);
        getBinding().e.configure(listComponent2);
        LinearLayout linearLayout = getBinding().f2700b;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.incomingCallAcceptAltContainer");
        linearLayout.setVisibility(callModel.getIsVideoCall() ? 0 : 8);
        getBinding().d.setOnClickListener(new AnonymousClass2(model));
        getBinding().c.setOnClickListener(new AnonymousClass3(model));
        getBinding().f.setOnClickListener(new AnonymousClass4(model));
    }

    public void onConnect(Model model, boolean useVideo) {
        Intrinsics3.checkNotNullParameter(model, "model");
        long channelId = model.getChannelId();
        if (model.getNumIncomingCalls() == 1) {
            Context contextRequireContext = requireContext();
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            PrivateCallLauncher privateCallLauncher = new PrivateCallLauncher(this, this, contextRequireContext, parentFragmentManager);
            if (useVideo) {
                privateCallLauncher.launchVideoCall(channelId);
            } else {
                privateCallLauncher.launchVoiceCall(channelId);
            }
        } else {
            if (useVideo) {
                StoreMediaEngine.selectDefaultVideoDevice$default(StoreStream.INSTANCE.getMediaEngine(), null, 1, null);
            }
            StoreStream.INSTANCE.getVoiceChannelSelected().selectVoiceChannel(channelId);
        }
        NotificationClient.clear$default(NotificationClient.INSTANCE, channelId, requireContext(), false, 4, null);
    }

    @MainThread
    public void onDecline(long channelId) {
        StoreCalls.stopRinging$default(StoreStream.INSTANCE.getCalls(), channelId, null, 2, null);
        NotificationClient.clear$default(NotificationClient.INSTANCE, channelId, requireContext(), false, 4, null);
    }

    public void onEmptyCallModel() {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        AppSoundManager.Provider.INSTANCE.get().stop(AppSound.INSTANCE.getSOUND_CALL_RINGING());
        super.onStop();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        Window window = fragmentActivityRequireActivity.getWindow();
        Intrinsics3.checkNotNullExpressionValue(window, "requireActivity().window");
        Intrinsics3.checkNotNullParameter(window, "window");
        if (Build.VERSION.SDK_INT >= 28) {
            window.getAttributes().layoutInDisplayCutoutMode = 1;
        }
        int color = ColorCompat.getColor(this, R.color.transparent);
        ColorCompat.setStatusBarTranslucent(this);
        ColorCompat.setStatusBarColor((Fragment) this, color, true);
        ViewCompat.setOnApplyWindowInsetsListener((ViewGroup) view, AnonymousClass1.INSTANCE);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(), this, null, 2, null), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
