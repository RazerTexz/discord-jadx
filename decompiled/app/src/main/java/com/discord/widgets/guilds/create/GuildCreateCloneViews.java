package com.discord.widgets.guilds.create;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import b.a.i.LayoutIconUploaderBinding;
import com.discord.databinding.WidgetGuildCloneBinding;
import com.discord.databinding.WidgetGuildCreateBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.discord.views.ScreenTitleView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GuildCreateCloneViews.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 \u001e2\u00020\u0001:\u0003\u001e\u001f R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/discord/widgets/guilds/create/GuildCreateCloneViews;", "", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getIconUploaderImage", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "iconUploaderImage", "Landroidx/constraintlayout/widget/Group;", "getIconUploaderPlaceholderGroup", "()Landroidx/constraintlayout/widget/Group;", "iconUploaderPlaceholderGroup", "Lcom/google/android/material/textfield/TextInputLayout;", "getGuildCreateName", "()Lcom/google/android/material/textfield/TextInputLayout;", "guildCreateName", "Landroid/widget/TextView;", "getGuidelinesTextView", "()Landroid/widget/TextView;", "guidelinesTextView", "Lcom/discord/views/LoadingButton;", "getGuildCreateButton", "()Lcom/discord/views/LoadingButton;", "guildCreateButton", "Lcom/discord/views/ScreenTitleView;", "getScreenTitleView", "()Lcom/discord/views/ScreenTitleView;", "screenTitleView", "Landroid/view/ViewGroup;", "getGuildCreateIconUploader", "()Landroid/view/ViewGroup;", "guildCreateIconUploader", "Companion", "GuildCloneViews", "GuildCreateViews", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public interface GuildCreateCloneViews {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* compiled from: GuildCreateCloneViews.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/guilds/create/GuildCreateCloneViews$Companion;", "", "Lcom/discord/databinding/WidgetGuildCreateBinding;", "binding", "Lcom/discord/widgets/guilds/create/GuildCreateCloneViews;", "from", "(Lcom/discord/databinding/WidgetGuildCreateBinding;)Lcom/discord/widgets/guilds/create/GuildCreateCloneViews;", "Lcom/discord/databinding/WidgetGuildCloneBinding;", "(Lcom/discord/databinding/WidgetGuildCloneBinding;)Lcom/discord/widgets/guilds/create/GuildCreateCloneViews;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final GuildCreateCloneViews from(WidgetGuildCreateBinding binding) {
            Intrinsics3.checkNotNullParameter(binding, "binding");
            return new GuildCreateViews(binding);
        }

        public final GuildCreateCloneViews from(WidgetGuildCloneBinding binding) {
            Intrinsics3.checkNotNullParameter(binding, "binding");
            return new GuildCloneViews(binding);
        }
    }

    /* compiled from: GuildCreateCloneViews.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(R\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u00020\u00118\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u00020\u001b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u00020 8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/discord/widgets/guilds/create/GuildCreateCloneViews$GuildCloneViews;", "Lcom/discord/widgets/guilds/create/GuildCreateCloneViews;", "Lcom/google/android/material/textfield/TextInputLayout;", "guildCreateName", "Lcom/google/android/material/textfield/TextInputLayout;", "getGuildCreateName", "()Lcom/google/android/material/textfield/TextInputLayout;", "Landroid/widget/TextView;", "guidelinesTextView", "Landroid/widget/TextView;", "getGuidelinesTextView", "()Landroid/widget/TextView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "iconUploaderImage", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getIconUploaderImage", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "Landroid/view/ViewGroup;", "guildCreateIconUploader", "Landroid/view/ViewGroup;", "getGuildCreateIconUploader", "()Landroid/view/ViewGroup;", "Lcom/discord/views/ScreenTitleView;", "screenTitleView", "Lcom/discord/views/ScreenTitleView;", "getScreenTitleView", "()Lcom/discord/views/ScreenTitleView;", "Lcom/discord/views/LoadingButton;", "guildCreateButton", "Lcom/discord/views/LoadingButton;", "getGuildCreateButton", "()Lcom/discord/views/LoadingButton;", "Landroidx/constraintlayout/widget/Group;", "iconUploaderPlaceholderGroup", "Landroidx/constraintlayout/widget/Group;", "getIconUploaderPlaceholderGroup", "()Landroidx/constraintlayout/widget/Group;", "Lcom/discord/databinding/WidgetGuildCloneBinding;", "binding", "<init>", "(Lcom/discord/databinding/WidgetGuildCloneBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class GuildCloneViews implements GuildCreateCloneViews {
        private final TextView guidelinesTextView;
        private final LoadingButton guildCreateButton;
        private final ViewGroup guildCreateIconUploader;
        private final TextInputLayout guildCreateName;
        private final SimpleDraweeView iconUploaderImage;
        private final Group iconUploaderPlaceholderGroup;
        private final ScreenTitleView screenTitleView;

        public GuildCloneViews(WidgetGuildCloneBinding widgetGuildCloneBinding) {
            Intrinsics3.checkNotNullParameter(widgetGuildCloneBinding, "binding");
            LoadingButton loadingButton = widgetGuildCloneBinding.f2410b;
            Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.guildCreateButton");
            this.guildCreateButton = loadingButton;
            TextInputLayout textInputLayout = widgetGuildCloneBinding.f;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildCreateName");
            this.guildCreateName = textInputLayout;
            SimpleDraweeView simpleDraweeView = widgetGuildCloneBinding.e.f190b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildCreateIconUploader.iconUploaderImage");
            this.iconUploaderImage = simpleDraweeView;
            Group group = widgetGuildCloneBinding.e.c;
            Intrinsics3.checkNotNullExpressionValue(group, "binding.guildCreateIconUploader.placeholderGroup");
            this.iconUploaderPlaceholderGroup = group;
            LayoutIconUploaderBinding layoutIconUploaderBinding = widgetGuildCloneBinding.e;
            Intrinsics3.checkNotNullExpressionValue(layoutIconUploaderBinding, "binding.guildCreateIconUploader");
            ConstraintLayout constraintLayout = layoutIconUploaderBinding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.guildCreateIconUploader.root");
            this.guildCreateIconUploader = constraintLayout;
            LinkifiedTextView linkifiedTextView = widgetGuildCloneBinding.d;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.guildCreateGuidelines");
            this.guidelinesTextView = linkifiedTextView;
        }

        @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
        public TextView getGuidelinesTextView() {
            return this.guidelinesTextView;
        }

        @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
        public LoadingButton getGuildCreateButton() {
            return this.guildCreateButton;
        }

        @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
        public ViewGroup getGuildCreateIconUploader() {
            return this.guildCreateIconUploader;
        }

        @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
        public TextInputLayout getGuildCreateName() {
            return this.guildCreateName;
        }

        @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
        public SimpleDraweeView getIconUploaderImage() {
            return this.iconUploaderImage;
        }

        @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
        public Group getIconUploaderPlaceholderGroup() {
            return this.iconUploaderPlaceholderGroup;
        }

        @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
        public ScreenTitleView getScreenTitleView() {
            return this.screenTitleView;
        }
    }

    /* compiled from: GuildCreateCloneViews.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(R\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u00020\u00118\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u00020\u00168\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u00020\u001b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u00020 8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/discord/widgets/guilds/create/GuildCreateCloneViews$GuildCreateViews;", "Lcom/discord/widgets/guilds/create/GuildCreateCloneViews;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "iconUploaderImage", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getIconUploaderImage", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "Lcom/google/android/material/textfield/TextInputLayout;", "guildCreateName", "Lcom/google/android/material/textfield/TextInputLayout;", "getGuildCreateName", "()Lcom/google/android/material/textfield/TextInputLayout;", "Landroid/widget/TextView;", "guidelinesTextView", "Landroid/widget/TextView;", "getGuidelinesTextView", "()Landroid/widget/TextView;", "Lcom/discord/views/LoadingButton;", "guildCreateButton", "Lcom/discord/views/LoadingButton;", "getGuildCreateButton", "()Lcom/discord/views/LoadingButton;", "Landroid/view/ViewGroup;", "guildCreateIconUploader", "Landroid/view/ViewGroup;", "getGuildCreateIconUploader", "()Landroid/view/ViewGroup;", "Landroidx/constraintlayout/widget/Group;", "iconUploaderPlaceholderGroup", "Landroidx/constraintlayout/widget/Group;", "getIconUploaderPlaceholderGroup", "()Landroidx/constraintlayout/widget/Group;", "Lcom/discord/views/ScreenTitleView;", "screenTitleView", "Lcom/discord/views/ScreenTitleView;", "getScreenTitleView", "()Lcom/discord/views/ScreenTitleView;", "Lcom/discord/databinding/WidgetGuildCreateBinding;", "binding", "<init>", "(Lcom/discord/databinding/WidgetGuildCreateBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class GuildCreateViews implements GuildCreateCloneViews {
        private final TextView guidelinesTextView;
        private final LoadingButton guildCreateButton;
        private final ViewGroup guildCreateIconUploader;
        private final TextInputLayout guildCreateName;
        private final SimpleDraweeView iconUploaderImage;
        private final Group iconUploaderPlaceholderGroup;
        private final ScreenTitleView screenTitleView;

        public GuildCreateViews(WidgetGuildCreateBinding widgetGuildCreateBinding) {
            Intrinsics3.checkNotNullParameter(widgetGuildCreateBinding, "binding");
            LoadingButton loadingButton = widgetGuildCreateBinding.f2412b;
            Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.guildCreateButton");
            this.guildCreateButton = loadingButton;
            TextInputLayout textInputLayout = widgetGuildCreateBinding.e;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildCreateName");
            this.guildCreateName = textInputLayout;
            SimpleDraweeView simpleDraweeView = widgetGuildCreateBinding.d.f190b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildCreateIconUploader.iconUploaderImage");
            this.iconUploaderImage = simpleDraweeView;
            Group group = widgetGuildCreateBinding.d.c;
            Intrinsics3.checkNotNullExpressionValue(group, "binding.guildCreateIconUploader.placeholderGroup");
            this.iconUploaderPlaceholderGroup = group;
            LayoutIconUploaderBinding layoutIconUploaderBinding = widgetGuildCreateBinding.d;
            Intrinsics3.checkNotNullExpressionValue(layoutIconUploaderBinding, "binding.guildCreateIconUploader");
            ConstraintLayout constraintLayout = layoutIconUploaderBinding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.guildCreateIconUploader.root");
            this.guildCreateIconUploader = constraintLayout;
            LinkifiedTextView linkifiedTextView = widgetGuildCreateBinding.c;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.guildCreateGuidelines");
            this.guidelinesTextView = linkifiedTextView;
            ScreenTitleView screenTitleView = widgetGuildCreateBinding.f;
            Intrinsics3.checkNotNullExpressionValue(screenTitleView, "binding.guildCreateScreenTitle");
            this.screenTitleView = screenTitleView;
        }

        @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
        public TextView getGuidelinesTextView() {
            return this.guidelinesTextView;
        }

        @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
        public LoadingButton getGuildCreateButton() {
            return this.guildCreateButton;
        }

        @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
        public ViewGroup getGuildCreateIconUploader() {
            return this.guildCreateIconUploader;
        }

        @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
        public TextInputLayout getGuildCreateName() {
            return this.guildCreateName;
        }

        @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
        public SimpleDraweeView getIconUploaderImage() {
            return this.iconUploaderImage;
        }

        @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
        public Group getIconUploaderPlaceholderGroup() {
            return this.iconUploaderPlaceholderGroup;
        }

        @Override // com.discord.widgets.guilds.create.GuildCreateCloneViews
        public ScreenTitleView getScreenTitleView() {
            return this.screenTitleView;
        }
    }

    TextView getGuidelinesTextView();

    LoadingButton getGuildCreateButton();

    ViewGroup getGuildCreateIconUploader();

    TextInputLayout getGuildCreateName();

    SimpleDraweeView getIconUploaderImage();

    Group getIconUploaderPlaceholderGroup();

    ScreenTitleView getScreenTitleView();
}
