package com.discord.widgets.guilds.create;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.LayoutRes;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetGuildCreateBinding;
import com.discord.dialogs.ImageUploadDialog;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.TextWatcher4;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.ScreenTitleView;
import com.discord.widgets.guilds.create.GuildCreateCloneViews;
import com.discord.widgets.guilds.create.WidgetGuildCreateViewModel;
import com.discord.widgets.guilds.invite.GuildInviteShareSheetFeatureFlag;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet;
import com.discord.widgets.nux.WidgetNuxChannelPrompt;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action1;

/* compiled from: WidgetGuildCreate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0016\u0018\u0000 52\u00020\u0001:\u0003567B\u0011\u0012\b\b\u0003\u00102\u001a\u000201¢\u0006\u0004\b3\u00104J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178T@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001e\u001a\u00020\t8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u000bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\u00020!8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001d\u0010+\u001a\u00020&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001d\u00100\u001a\u00020,8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u001c\u001a\u0004\b.\u0010/¨\u00068"}, d2 = {"Lcom/discord/widgets/guilds/create/WidgetGuildCreate;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$Event;", "event", "", "handleEvent", "(Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$Event;)V", "onResume", "()V", "Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel;", "createViewModelFactory", "()Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel;", "Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$ViewState;", "viewState", "configureUI", "(Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$ViewState;)V", "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "", "mimeType", "onImageChosen", "(Landroid/net/Uri;Ljava/lang/String;)V", "onImageCropped", "Lcom/discord/widgets/guilds/create/GuildCreateCloneViews;", "getViews", "()Lcom/discord/widgets/guilds/create/GuildCreateCloneViews;", "views", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "viewModel", "currentImageUri", "Ljava/lang/String;", "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "Lcom/discord/databinding/WidgetGuildCreateBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetGuildCreateBinding;", "binding", "Lcom/discord/widgets/guilds/create/WidgetGuildCreate$Options;", "args$delegate", "getArgs", "()Lcom/discord/widgets/guilds/create/WidgetGuildCreate$Options;", "args", "", "contentResId", "<init>", "(I)V", "Companion", "Options", "Result", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public class WidgetGuildCreate extends AppFragment {
    public static final String ANALYTICS_SOURCE = "Guild Create";
    public static final String EXTRA_OPTIONS = "com.discord.intent.extra.EXTRA_OPTIONS";
    private static final String GUIDELINES_URL = "https://discord.com/guidelines";

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private String currentImageUri;
    private final AppLogger2 loggingConfig;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildCreate.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildCreateBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetGuildCreate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\r8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/guilds/create/WidgetGuildCreate$Companion;", "", "Landroid/content/Context;", "context", "Lcom/discord/widgets/guilds/create/WidgetGuildCreate$Options;", "options", "", "show", "(Landroid/content/Context;Lcom/discord/widgets/guilds/create/WidgetGuildCreate$Options;)V", "Lcom/discord/app/AppFragment;", "fragment", "showFragment", "(Lcom/discord/app/AppFragment;Lcom/discord/widgets/guilds/create/WidgetGuildCreate$Options;)V", "", "ANALYTICS_SOURCE", "Ljava/lang/String;", "EXTRA_OPTIONS", "GUIDELINES_URL", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, Options options) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(options, "options");
            Intent intent = new Intent();
            intent.putExtra(WidgetGuildCreate.EXTRA_OPTIONS, options);
            AppScreen2.d(context, WidgetGuildCreate.class, intent);
        }

        public final void showFragment(AppFragment fragment, Options options) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(options, "options");
            Bundle bundle = new Bundle();
            bundle.putParcelable(WidgetGuildCreate.EXTRA_OPTIONS, options);
            AppScreen2.g(AppScreen2.g, fragment.getParentFragmentManager(), fragment.requireContext(), WidgetGuildCreate.class, 0, true, null, bundle, 40);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildCreate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\f\u0010\nJD\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0011\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0017J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u0019\u0010\u000f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010#\u001a\u0004\b$\u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b&\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010%\u001a\u0004\b'\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b(\u0010\nR\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010)\u001a\u0004\b*\u0010\u0007¨\u0006-"}, d2 = {"Lcom/discord/widgets/guilds/create/WidgetGuildCreate$Options;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lcom/discord/widgets/guilds/create/StockGuildTemplate;", "component2", "()Lcom/discord/widgets/guilds/create/StockGuildTemplate;", "", "component3", "()Z", "component4", "component5", "analyticsLocation", "template", "showChannelPrompt", "customTitle", "closeWithResult", "copy", "(Ljava/lang/String;Lcom/discord/widgets/guilds/create/StockGuildTemplate;ZLjava/lang/String;Z)Lcom/discord/widgets/guilds/create/WidgetGuildCreate$Options;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Z", "getShowChannelPrompt", "Ljava/lang/String;", "getCustomTitle", "getAnalyticsLocation", "getCloseWithResult", "Lcom/discord/widgets/guilds/create/StockGuildTemplate;", "getTemplate", "<init>", "(Ljava/lang/String;Lcom/discord/widgets/guilds/create/StockGuildTemplate;ZLjava/lang/String;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Options implements Parcelable {
        public static final Parcelable.Creator<Options> CREATOR = new Creator();
        private final String analyticsLocation;
        private final boolean closeWithResult;
        private final String customTitle;
        private final boolean showChannelPrompt;
        private final StockGuildTemplate template;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Options> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Options createFromParcel(Parcel parcel) {
                Intrinsics3.checkNotNullParameter(parcel, "in");
                return new Options(parcel.readString(), (StockGuildTemplate) Enum.valueOf(StockGuildTemplate.class, parcel.readString()), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0);
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

        public Options(String str, StockGuildTemplate stockGuildTemplate, boolean z2, String str2, boolean z3) {
            Intrinsics3.checkNotNullParameter(str, "analyticsLocation");
            Intrinsics3.checkNotNullParameter(stockGuildTemplate, "template");
            this.analyticsLocation = str;
            this.template = stockGuildTemplate;
            this.showChannelPrompt = z2;
            this.customTitle = str2;
            this.closeWithResult = z3;
        }

        public static /* synthetic */ Options copy$default(Options options, String str, StockGuildTemplate stockGuildTemplate, boolean z2, String str2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = options.analyticsLocation;
            }
            if ((i & 2) != 0) {
                stockGuildTemplate = options.template;
            }
            StockGuildTemplate stockGuildTemplate2 = stockGuildTemplate;
            if ((i & 4) != 0) {
                z2 = options.showChannelPrompt;
            }
            boolean z4 = z2;
            if ((i & 8) != 0) {
                str2 = options.customTitle;
            }
            String str3 = str2;
            if ((i & 16) != 0) {
                z3 = options.closeWithResult;
            }
            return options.copy(str, stockGuildTemplate2, z4, str3, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getAnalyticsLocation() {
            return this.analyticsLocation;
        }

        /* renamed from: component2, reason: from getter */
        public final StockGuildTemplate getTemplate() {
            return this.template;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getShowChannelPrompt() {
            return this.showChannelPrompt;
        }

        /* renamed from: component4, reason: from getter */
        public final String getCustomTitle() {
            return this.customTitle;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getCloseWithResult() {
            return this.closeWithResult;
        }

        public final Options copy(String analyticsLocation, StockGuildTemplate template, boolean showChannelPrompt, String customTitle, boolean closeWithResult) {
            Intrinsics3.checkNotNullParameter(analyticsLocation, "analyticsLocation");
            Intrinsics3.checkNotNullParameter(template, "template");
            return new Options(analyticsLocation, template, showChannelPrompt, customTitle, closeWithResult);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Options)) {
                return false;
            }
            Options options = (Options) other;
            return Intrinsics3.areEqual(this.analyticsLocation, options.analyticsLocation) && Intrinsics3.areEqual(this.template, options.template) && this.showChannelPrompt == options.showChannelPrompt && Intrinsics3.areEqual(this.customTitle, options.customTitle) && this.closeWithResult == options.closeWithResult;
        }

        public final String getAnalyticsLocation() {
            return this.analyticsLocation;
        }

        public final boolean getCloseWithResult() {
            return this.closeWithResult;
        }

        public final String getCustomTitle() {
            return this.customTitle;
        }

        public final boolean getShowChannelPrompt() {
            return this.showChannelPrompt;
        }

        public final StockGuildTemplate getTemplate() {
            return this.template;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.analyticsLocation;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            StockGuildTemplate stockGuildTemplate = this.template;
            int iHashCode2 = (iHashCode + (stockGuildTemplate != null ? stockGuildTemplate.hashCode() : 0)) * 31;
            boolean z2 = this.showChannelPrompt;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            String str2 = this.customTitle;
            int iHashCode3 = (i2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z3 = this.closeWithResult;
            return iHashCode3 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Options(analyticsLocation=");
            sbU.append(this.analyticsLocation);
            sbU.append(", template=");
            sbU.append(this.template);
            sbU.append(", showChannelPrompt=");
            sbU.append(this.showChannelPrompt);
            sbU.append(", customTitle=");
            sbU.append(this.customTitle);
            sbU.append(", closeWithResult=");
            return outline.O(sbU, this.closeWithResult, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.analyticsLocation);
            parcel.writeString(this.template.name());
            parcel.writeInt(this.showChannelPrompt ? 1 : 0);
            parcel.writeString(this.customTitle);
            parcel.writeInt(this.closeWithResult ? 1 : 0);
        }

        public /* synthetic */ Options(String str, StockGuildTemplate stockGuildTemplate, boolean z2, String str2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? StockGuildTemplate.CREATE : stockGuildTemplate, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? false : z3);
        }
    }

    /* compiled from: WidgetGuildCreate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u001d\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u0005¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/guilds/create/WidgetGuildCreate$Result;", "Landroid/os/Parcelable;", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "guildId", "copy", "(J)Lcom/discord/widgets/guilds/create/WidgetGuildCreate$Result;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "J", "getGuildId", "<init>", "(J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Result implements Parcelable {
        public static final Parcelable.Creator<Result> CREATOR = new Creator();
        private final long guildId;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Result> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Result createFromParcel(Parcel parcel) {
                Intrinsics3.checkNotNullParameter(parcel, "in");
                return new Result(parcel.readLong());
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Result createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Result[] newArray(int i) {
                return new Result[i];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Result[] newArray(int i) {
                return newArray(i);
            }
        }

        public Result(long j) {
            this.guildId = j;
        }

        public static /* synthetic */ Result copy$default(Result result, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = result.guildId;
            }
            return result.copy(j);
        }

        /* renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        public final Result copy(long guildId) {
            return new Result(guildId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Result) && this.guildId == ((Result) other).guildId;
            }
            return true;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public int hashCode() {
            return b.a(this.guildId);
        }

        public String toString() {
            return outline.C(outline.U("Result(guildId="), this.guildId, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            parcel.writeLong(this.guildId);
        }
    }

    /* compiled from: WidgetGuildCreate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreate$onImageChosen$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<String> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(String str) {
            call2(str);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(String str) {
            WidgetGuildCreate.access$getViewModel$p(WidgetGuildCreate.this).updateGuildIconUri(str);
        }
    }

    /* compiled from: WidgetGuildCreate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreate$onImageCropped$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<String> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(String str) {
            call2(str);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(String str) {
            WidgetGuildCreate.access$getViewModel$p(WidgetGuildCreate.this).updateGuildIconUri(str);
        }
    }

    /* compiled from: WidgetGuildCreate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$ViewState;", "it", "", "invoke", "(Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreate$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetGuildCreateViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildCreateViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildCreateViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetGuildCreate.this.configureUI(viewState);
        }
    }

    /* compiled from: WidgetGuildCreate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$Event;", "it", "", "invoke", "(Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreate$onResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<WidgetGuildCreateViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildCreateViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildCreateViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "it");
            WidgetGuildCreate.access$handleEvent(WidgetGuildCreate.this, event);
        }
    }

    /* compiled from: WidgetGuildCreate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreate$onResume$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildCreate widgetGuildCreate = WidgetGuildCreate.this;
            widgetGuildCreate.hideKeyboard(widgetGuildCreate.getViews().getGuildCreateName());
            WidgetGuildCreate.this.openMediaChooser();
        }
    }

    /* compiled from: WidgetGuildCreate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreate$onResume$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
            WidgetGuildCreate.access$getViewModel$p(WidgetGuildCreate.this).updateGuildName(str);
        }
    }

    /* compiled from: WidgetGuildCreate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreate$onResume$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildCreate.access$getViewModel$p(WidgetGuildCreate.this).createGuild(WidgetGuildCreate.this.requireContext());
            WidgetGuildCreate widgetGuildCreate = WidgetGuildCreate.this;
            widgetGuildCreate.hideKeyboard(widgetGuildCreate.getView());
        }
    }

    public WidgetGuildCreate() {
        this(0, 1, null);
    }

    public WidgetGuildCreate(@LayoutRes int i) {
        super(i);
        this.args = LazyJVM.lazy(new WidgetGuildCreate$$special$$inlined$args$1(this, EXTRA_OPTIONS));
        WidgetGuildCreate4 widgetGuildCreate4 = new WidgetGuildCreate4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGuildCreateViewModel.class), new WidgetGuildCreate$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildCreate4));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildCreate2.INSTANCE, null, 2, null);
        this.loggingConfig = new AppLogger2(false, null, new WidgetGuildCreate3(this), 3);
    }

    public static final /* synthetic */ WidgetGuildCreateViewModel access$getViewModel$p(WidgetGuildCreate widgetGuildCreate) {
        return widgetGuildCreate.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetGuildCreate widgetGuildCreate, WidgetGuildCreateViewModel.Event event) {
        widgetGuildCreate.handleEvent(event);
    }

    private final WidgetGuildCreateBinding getBinding() {
        return (WidgetGuildCreateBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetGuildCreateViewModel getViewModel() {
        return (WidgetGuildCreateViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetGuildCreateViewModel.Event event) {
        if (event instanceof WidgetGuildCreateViewModel.Event.ShowToast) {
            AppToast.i(this, ((WidgetGuildCreateViewModel.Event.ShowToast) event).getStringResId(), 0, 4);
            return;
        }
        if (event instanceof WidgetGuildCreateViewModel.Event.LaunchChannelPrompt) {
            WidgetNuxChannelPrompt.INSTANCE.launch(requireContext(), ((WidgetGuildCreateViewModel.Event.LaunchChannelPrompt) event).getGuildId());
            requireActivity().finish();
            return;
        }
        if (event instanceof WidgetGuildCreateViewModel.Event.CloseWithResult) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setResult(-1, AnimatableValueParser.g2(new Result(((WidgetGuildCreateViewModel.Event.CloseWithResult) event).getGuildId())));
                activity.finish();
                return;
            }
            return;
        }
        if (event instanceof WidgetGuildCreateViewModel.Event.LaunchInviteShareScreen) {
            if (GuildInviteShareSheetFeatureFlag.INSTANCE.getINSTANCE().isEnabled()) {
                WidgetGuildInviteShareSheet.Companion.enqueueNoticeForHomeTab$default(WidgetGuildInviteShareSheet.INSTANCE, null, ((WidgetGuildCreateViewModel.Event.LaunchInviteShareScreen) event).getGuildId(), "Guild Create", 1, null);
                AppScreen2.c(requireContext(), false, null, 6);
            } else {
                WidgetGuildInviteShare.Companion companion = WidgetGuildInviteShare.INSTANCE;
                Context contextRequireContext = requireContext();
                FragmentManager parentFragmentManager = getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                WidgetGuildInviteShare.Companion.launch$default(companion, contextRequireContext, parentFragmentManager, ((WidgetGuildCreateViewModel.Event.LaunchInviteShareScreen) event).getGuildId(), null, true, null, null, "Guild Create", 96, null);
            }
            requireActivity().finish();
        }
    }

    public void configureUI(WidgetGuildCreateViewModel.ViewState viewState) {
        ScreenTitleView screenTitleView;
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        if (!Intrinsics3.areEqual(viewState, WidgetGuildCreateViewModel.ViewState.Uninitialized.INSTANCE) && (viewState instanceof WidgetGuildCreateViewModel.ViewState.Initialized)) {
            WidgetGuildCreateViewModel.ViewState.Initialized initialized = (WidgetGuildCreateViewModel.ViewState.Initialized) viewState;
            String guildName = initialized.getGuildName(requireContext());
            if (!Intrinsics3.areEqual(guildName, ViewExtensions.getTextOrEmpty(getViews().getGuildCreateName()))) {
                ViewExtensions.setText(getViews().getGuildCreateName(), guildName);
            }
            if (!Intrinsics3.areEqual(this.currentImageUri, initialized.getGuildIconUri())) {
                getViews().getIconUploaderPlaceholderGroup().setVisibility(initialized.getGuildIconUri() == null ? 0 : 8);
                IconUtils.setIcon$default(getViews().getIconUploaderImage(), initialized.getGuildIconUri(), R.dimen.avatar_size_xxlarge, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
                this.currentImageUri = initialized.getGuildIconUri();
            }
            if (initialized.getCustomTitle() != null && (screenTitleView = getViews().getScreenTitleView()) != null) {
                screenTitleView.setTitle(initialized.getCustomTitle());
            }
            getViews().getGuildCreateButton().setIsLoading(initialized.isBusy());
        }
    }

    public WidgetGuildCreateViewModel createViewModelFactory() {
        return new WidgetGuildCreateViewModel(R.string.create_server_default_server_name_format, getArgs().getTemplate(), null, getArgs().getShowChannelPrompt(), getArgs().getAnalyticsLocation(), getArgs().getCustomTitle(), getArgs().getCloseWithResult(), null, null, null, 896, null);
    }

    public final Options getArgs() {
        return (Options) this.args.getValue();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    public GuildCreateCloneViews getViews() {
        GuildCreateCloneViews.Companion companion = GuildCreateCloneViews.INSTANCE;
        WidgetGuildCreateBinding binding = getBinding();
        Intrinsics3.checkNotNullExpressionValue(binding, "binding");
        return companion.from(binding);
    }

    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        MGImages.prepareImageUpload(uri, mimeType, parentFragmentManager, this, new AnonymousClass1(), ImageUploadDialog.PreviewType.GUILD_AVATAR);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        MGImages.requestDataUrl(requireContext(), uri, mimeType, new AnonymousClass1());
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
        getViews().getGuildCreateIconUploader().setOnClickListener(new AnonymousClass3());
        FormatUtils.n(getViews().getGuidelinesTextView(), R.string.create_server_guidelines, new Object[]{GUIDELINES_URL}, null, 4);
        EditText editText = getViews().getGuildCreateName().getEditText();
        if (editText != null) {
            TextWatcher4.addLifecycleAwareTextWatcher(editText, this, new AnonymousClass4());
        }
        getViews().getGuildCreateButton().setOnClickListener(new AnonymousClass5());
    }

    public /* synthetic */ WidgetGuildCreate(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? R.layout.widget_guild_create : i);
    }
}
