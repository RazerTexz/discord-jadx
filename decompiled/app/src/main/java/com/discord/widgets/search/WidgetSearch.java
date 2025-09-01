package com.discord.widgets.search;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSearchBinding;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreSearch;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.strings.ContextSearchStringProvider;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetSearch.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 (2\u00020\u0001:\u0002()B\u0007¢\u0006\u0004\b'\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\bR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001f\u001a\u00020\u001a8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/discord/widgets/search/WidgetSearch;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/search/WidgetSearch$Model;", "model", "", "configureUI", "(Lcom/discord/widgets/search/WidgetSearch$Model;)V", "configureSearchInput", "()V", "Landroid/content/Context;", "context", "sendQuery", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "onDestroy", "", "targetType", "I", "getTargetType", "()I", "setTargetType", "(I)V", "Lcom/discord/databinding/WidgetSearchBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetSearchBinding;", "binding", "", "targetId", "J", "getTargetId", "()J", "setTargetId", "(J)V", "<init>", "Companion", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetSearch extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSearch.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSearchBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String INTENT_EXTRA_TARGET_ID = "INTENT_EXTRA_TARGET_ID";
    public static final String INTENT_EXTRA_TARGET_TYPE = "INTENT_EXTRA_SEARCH_TYPE";
    private static final int TARGET_TYPE_CHANNEL = 1;
    private static final int TARGET_TYPE_GUILD = 0;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private long targetId;
    private int targetType;

    /* compiled from: WidgetSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00108\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/search/WidgetSearch$Companion;", "", "", "targetId", "", "targetType", "Landroid/content/Context;", "context", "", "launch", "(JILandroid/content/Context;)V", "guildId", "launchForGuild", "(JLandroid/content/Context;)V", "channelId", "launchForChannel", "", WidgetSearch.INTENT_EXTRA_TARGET_ID, "Ljava/lang/String;", "INTENT_EXTRA_TARGET_TYPE", "TARGET_TYPE_CHANNEL", "I", "TARGET_TYPE_GUILD", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        private final void launch(long targetId, int targetType, Context context) {
            Intent intentPutExtra = new Intent().putExtra(WidgetSearch.INTENT_EXTRA_TARGET_ID, targetId).putExtra(WidgetSearch.INTENT_EXTRA_TARGET_TYPE, targetType);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_TARGET_TYPE, targetType)");
            AppScreen2.d(context, WidgetSearch.class, intentPutExtra);
        }

        public final void launchForChannel(long channelId, Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            launch(channelId, 1, context);
        }

        public final void launchForGuild(long guildId, Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            launch(guildId, 0, context);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0082\b\u0018\u0000 &2\u00020\u0001:\u0001&B-\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b$\u0010%J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ>\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0011\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001e\u0010\nR\u0019\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b\u0011\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\u0007R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b#\u0010\u0004¨\u0006'"}, d2 = {"Lcom/discord/widgets/search/WidgetSearch$Model;", "", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/api/channel/Channel;", "component2", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/stores/StoreSearch$DisplayState;", "component3", "()Lcom/discord/stores/StoreSearch$DisplayState;", "", "component4", "()Z", "guild", "channel", "displayState", "isQueryValid", "copy", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;Lcom/discord/stores/StoreSearch$DisplayState;Z)Lcom/discord/widgets/search/WidgetSearch$Model;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/StoreSearch$DisplayState;", "getDisplayState", "Z", "Lcom/discord/api/channel/Channel;", "getChannel", "Lcom/discord/models/guild/Guild;", "getGuild", "<init>", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;Lcom/discord/stores/StoreSearch$DisplayState;Z)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Channel channel;
        private final StoreSearch.DisplayState displayState;
        private final Guild guild;
        private final boolean isQueryValid;

        /* compiled from: WidgetSearch.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/search/WidgetSearch$Model$Companion;", "", "", "targetType", "", "targetId", "Lrx/Observable;", "Lcom/discord/widgets/search/WidgetSearch$Model;", "get", "(IJ)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(int targetType, long targetId) {
                Observable<Guild> observableObserveGuild = targetType == 0 ? StoreStream.INSTANCE.getGuilds().observeGuild(targetId) : new ScalarSynchronousObservable<>(null);
                Observable<Channel> observableObservePrivateChannel = targetType == 1 ? StoreStream.INSTANCE.getChannels().observePrivateChannel(targetId) : new ScalarSynchronousObservable<>(null);
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableH = Observable.h(observableObserveGuild, observableObservePrivateChannel, companion.getSearch().getDisplayState(), companion.getSearch().getStoreSearchInput().isInputValid(), WidgetSearch2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableH, "Observable\n            .…          }\n            }");
                return ObservableExtensionsKt.computationLatest(observableH);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Guild guild, Channel channel, StoreSearch.DisplayState displayState, boolean z2) {
            this.guild = guild;
            this.channel = channel;
            this.displayState = displayState;
            this.isQueryValid = z2;
        }

        public static /* synthetic */ Model copy$default(Model model, Guild guild, Channel channel, StoreSearch.DisplayState displayState, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = model.guild;
            }
            if ((i & 2) != 0) {
                channel = model.channel;
            }
            if ((i & 4) != 0) {
                displayState = model.displayState;
            }
            if ((i & 8) != 0) {
                z2 = model.isQueryValid;
            }
            return model.copy(guild, channel, displayState, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component3, reason: from getter */
        public final StoreSearch.DisplayState getDisplayState() {
            return this.displayState;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsQueryValid() {
            return this.isQueryValid;
        }

        public final Model copy(Guild guild, Channel channel, StoreSearch.DisplayState displayState, boolean isQueryValid) {
            return new Model(guild, channel, displayState, isQueryValid);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.channel, model.channel) && Intrinsics3.areEqual(this.displayState, model.displayState) && this.isQueryValid == model.isQueryValid;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final StoreSearch.DisplayState getDisplayState() {
            return this.displayState;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            StoreSearch.DisplayState displayState = this.displayState;
            int iHashCode3 = (iHashCode2 + (displayState != null ? displayState.hashCode() : 0)) * 31;
            boolean z2 = this.isQueryValid;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode3 + i;
        }

        public final boolean isQueryValid() {
            return this.isQueryValid;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(guild=");
            sbU.append(this.guild);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", displayState=");
            sbU.append(this.displayState);
            sbU.append(", isQueryValid=");
            return outline.O(sbU, this.isQueryValid, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            StoreSearch.DisplayState.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[StoreSearch.DisplayState.SUGGESTIONS.ordinal()] = 1;
            iArr[StoreSearch.DisplayState.RESULTS.ordinal()] = 2;
        }
    }

    /* compiled from: WidgetSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroid/widget/TextView;", "textView", "", "actionId", "Landroid/view/KeyEvent;", "<anonymous parameter 2>", "", "invoke", "(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.search.WidgetSearch$configureSearchInput$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function3<TextView, Integer, KeyEvent, Boolean> {
        public AnonymousClass1() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Boolean invoke(TextView textView, Integer num, KeyEvent keyEvent) {
            return Boolean.valueOf(invoke(textView, num.intValue(), keyEvent));
        }

        public final boolean invoke(TextView textView, int i, KeyEvent keyEvent) {
            Intrinsics3.checkNotNullParameter(textView, "textView");
            if (i != 2 && i != 3 && i != 6) {
                return false;
            }
            AppFragment.hideKeyboard$default(WidgetSearch.this, null, 1, null);
            StoreSearch search = StoreStream.INSTANCE.getSearch();
            TextInputLayout textInputLayout = WidgetSearch.access$getBinding$p(WidgetSearch.this).c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            Context context = textView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "textView.context");
            search.loadInitial(textOrEmpty, new ContextSearchStringProvider(context));
            return true;
        }
    }

    /* compiled from: WidgetSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/text/Editable;", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "", "invoke", "(Landroid/text/Editable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.search.WidgetSearch$configureSearchInput$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Editable, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            StoreStream.INSTANCE.getSearch().getStoreSearchInput().updateInput(editable.toString());
        }
    }

    /* compiled from: WidgetSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\n \u0002*\u0004\u0018\u00010\u00040\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/utilities/search/query/node/QueryNode;", "kotlin.jvm.PlatformType", "queryNodes", "Lcom/facebook/drawee/span/DraweeSpanStringBuilder;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Lcom/facebook/drawee/span/DraweeSpanStringBuilder;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.search.WidgetSearch$configureSearchInput$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements Func1<List<? extends QueryNode>, DraweeSpanStringBuilder> {
        public AnonymousClass3() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ DraweeSpanStringBuilder call(List<? extends QueryNode> list) {
            return call2(list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final DraweeSpanStringBuilder call2(List<? extends QueryNode> list) {
            Intrinsics3.checkNotNullExpressionValue(list, "queryNodes");
            return AstRenderer.render(list, WidgetSearch.this.requireContext());
        }
    }

    /* compiled from: WidgetSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/facebook/drawee/span/DraweeSpanStringBuilder;", IconCompat.EXTRA_OBJ, "", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/facebook/drawee/span/DraweeSpanStringBuilder;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.search.WidgetSearch$configureSearchInput$4, reason: invalid class name */
    public static final class AnonymousClass4<T, R> implements Func1<DraweeSpanStringBuilder, String> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ String call(DraweeSpanStringBuilder draweeSpanStringBuilder) {
            return call2(draweeSpanStringBuilder);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final String call2(DraweeSpanStringBuilder draweeSpanStringBuilder) {
            Intrinsics3.checkNotNullParameter(draweeSpanStringBuilder, IconCompat.EXTRA_OBJ);
            return draweeSpanStringBuilder.toString();
        }
    }

    /* compiled from: WidgetSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "charSequence", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.search.WidgetSearch$configureSearchInput$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            TextInputLayout textInputLayout = WidgetSearch.access$getBinding$p(WidgetSearch.this).c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
            ViewExtensions.setText(textInputLayout, str);
            TextInputLayout textInputLayout2 = WidgetSearch.access$getBinding$p(WidgetSearch.this).c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.widgetSearchInput");
            ViewExtensions.setSelectionEnd(textInputLayout2);
        }
    }

    /* compiled from: WidgetSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/search/WidgetSearch$Model;", "model", "", "invoke", "(Lcom/discord/widgets/search/WidgetSearch$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.search.WidgetSearch$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetSearch.access$configureUI(WidgetSearch.this, model);
        }
    }

    /* compiled from: WidgetSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "v", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.search.WidgetSearch$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSearch widgetSearch = WidgetSearch.this;
            Intrinsics3.checkNotNullExpressionValue(view, "v");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "v.context");
            WidgetSearch.access$sendQuery(widgetSearch, context);
        }
    }

    /* compiled from: WidgetSearch.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "view", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.search.WidgetSearch$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSearch.this.hideKeyboard(view);
            WidgetSearch.this.requireActivity().onBackPressed();
        }
    }

    public WidgetSearch() {
        super(R.layout.widget_search);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSearch3.INSTANCE, null, 2, null);
        this.targetType = -1;
    }

    public static final /* synthetic */ void access$configureUI(WidgetSearch widgetSearch, Model model) {
        widgetSearch.configureUI(model);
    }

    public static final /* synthetic */ WidgetSearchBinding access$getBinding$p(WidgetSearch widgetSearch) {
        return widgetSearch.getBinding();
    }

    public static final /* synthetic */ void access$sendQuery(WidgetSearch widgetSearch, Context context) {
        widgetSearch.sendQuery(context);
    }

    private final void configureSearchInput() {
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
        ViewExtensions.setOnEditorActionListener(textInputLayout, new AnonymousClass1());
        TextInputLayout textInputLayout2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.widgetSearchInput");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, AnonymousClass2.INSTANCE);
        Observable observableG = ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getSearch().getStoreSearchInput().getForcedInput(), this, null, 2, null).G(new AnonymousClass3()).G(AnonymousClass4.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "StoreStream\n        .get… obj.toString()\n        }");
        ObservableExtensionsKt.appSubscribe$default(observableG, WidgetSearch.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass5(), 62, (Object) null);
    }

    private final void configureUI(Model model) {
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        int i = this.targetType;
        if (i == 0) {
            TextInputLayout textInputLayout = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
            Object[] objArr = new Object[1];
            Guild guild = model.getGuild();
            objArr[0] = guild != null ? guild.getName() : null;
            ViewExtensions.setSingleLineHint(textInputLayout, FormatUtils.k(this, R.string.search_in, objArr, null, 4));
        } else if (i == 1) {
            Channel channel = model.getChannel();
            String strD = channel != null ? ChannelUtils.d(channel, requireContext(), false) : null;
            TextInputLayout textInputLayout2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.widgetSearchInput");
            Channel channel2 = model.getChannel();
            Integer numValueOf = channel2 != null ? Integer.valueOf(channel2.getType()) : null;
            ViewExtensions.setSingleLineHint(textInputLayout2, (numValueOf != null && numValueOf.intValue() == 1) ? FormatUtils.k(this, R.string.search_dm_with, new Object[]{strD}, null, 4) : (numValueOf != null && numValueOf.intValue() == 3) ? FormatUtils.k(this, R.string.search_in, new Object[]{strD}, null, 4) : FormatUtils.k(this, R.string.search, new Object[0], null, 4));
        }
        StoreSearch.DisplayState displayState = model.getDisplayState();
        if (displayState == null) {
            return;
        }
        int iOrdinal = displayState.ordinal();
        if (iOrdinal == 0) {
            FragmentContainerView fragmentContainerView = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(fragmentContainerView, "binding.widgetSearchSuggestions");
            fragmentContainerView.setVisibility(0);
            FragmentContainerView fragmentContainerView2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(fragmentContainerView2, "binding.widgetSearchResults");
            fragmentContainerView2.setVisibility(4);
            FloatingActionButton floatingActionButton = getBinding().f2522b;
            Intrinsics3.checkNotNullExpressionValue(floatingActionButton, "binding.searchSendQueryFab");
            floatingActionButton.setVisibility(model.isQueryValid() ? 0 : 8);
            return;
        }
        if (iOrdinal != 1) {
            return;
        }
        FragmentContainerView fragmentContainerView3 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView3, "binding.widgetSearchSuggestions");
        fragmentContainerView3.setVisibility(4);
        FragmentContainerView fragmentContainerView4 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView4, "binding.widgetSearchResults");
        fragmentContainerView4.setVisibility(0);
        FloatingActionButton floatingActionButton2 = getBinding().f2522b;
        Intrinsics3.checkNotNullExpressionValue(floatingActionButton2, "binding.searchSendQueryFab");
        floatingActionButton2.setVisibility(8);
    }

    private final WidgetSearchBinding getBinding() {
        return (WidgetSearchBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void sendQuery(Context context) {
        AppFragment.hideKeyboard$default(this, null, 1, null);
        StoreSearch search = StoreStream.INSTANCE.getSearch();
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
        search.loadInitial(ViewExtensions.getTextOrEmpty(textInputLayout), new ContextSearchStringProvider(context));
    }

    public final long getTargetId() {
        return this.targetId;
    }

    public final int getTargetType() {
        return this.targetType;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        StoreStream.INSTANCE.getSearch().clear();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setRetainInstance(true);
        this.targetId = getMostRecentIntent().getLongExtra(INTENT_EXTRA_TARGET_ID, 0L);
        this.targetType = getMostRecentIntent().getIntExtra(INTENT_EXTRA_TARGET_TYPE, -1);
        if (!getIsRecreated()) {
            TextInputLayout textInputLayout = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
            showKeyboard(textInputLayout);
        }
        int i = this.targetType;
        if (i == 0) {
            StoreStream.INSTANCE.getSearch().initForGuild(this.targetId, new ContextSearchStringProvider(requireContext()));
        } else {
            if (i != 1) {
                return;
            }
            StoreStream.INSTANCE.getSearch().initForChannel(this.targetId, new ContextSearchStringProvider(requireContext()));
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(this.targetType, this.targetId), this, null, 2, null), WidgetSearch.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        configureSearchInput();
        getBinding().f2522b.setOnClickListener(new AnonymousClass2());
        getBinding().c.setStartIconOnClickListener(new AnonymousClass3());
    }

    public final void setTargetId(long j) {
        this.targetId = j;
    }

    public final void setTargetType(int i) {
        this.targetType = i;
    }
}
