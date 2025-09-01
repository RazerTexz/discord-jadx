package com.discord.widgets.chat.input;

import android.content.ContentResolver;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.app.NotificationCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.WidgetChatInputPermReqFilesBinding;
import b.a.k.FormatUtils;
import b.b.a.d.AddContentPagerAdapter4;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.attachments.AttachmentUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.widgets.chat.input.expression.WidgetExpressionTray;
import com.google.android.material.button.MaterialButton;
import com.lytefast.flexinput.FlexInputListener;
import com.lytefast.flexinput.adapters.AttachmentPreviewAdapter;
import com.lytefast.flexinput.adapters.EmptyListAdapter;
import com.lytefast.flexinput.fragment.FilesFragment;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.fragment.MediaFragment;
import com.lytefast.flexinput.managers.FileManager;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionAggregator;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.functions.Func0;

/* compiled from: WidgetChatInputAttachments.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0003-./B\u000f\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b+\u0010,J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012\"\u000e\b\u0000\u0010\u0011*\b\u0012\u0004\u0012\u00020\u00010\u00102\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b#\u0010$J\u001b\u0010&\u001a\u00020\r2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u00060"}, d2 = {"Lcom/discord/widgets/chat/input/WidgetChatInputAttachments;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Landroid/widget/TextView;", "chatInput", "Landroidx/fragment/app/Fragment;", "createAndConfigureExpressionFragment", "(Landroidx/fragment/app/FragmentManager;Landroid/widget/TextView;)Landroidx/fragment/app/Fragment;", "Landroid/content/Context;", "context", "Landroidx/core/view/inputmethod/InputContentInfoCompat;", "inputContentInfoCompat", "", "setAttachmentFromPicker", "(Landroid/content/Context;Landroidx/core/view/inputmethod/InputContentInfoCompat;)V", "Lcom/lytefast/flexinput/model/Attachment;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/lytefast/flexinput/adapters/AttachmentPreviewAdapter;", "createPreviewAdapter", "(Landroid/content/Context;)Lcom/lytefast/flexinput/adapters/AttachmentPreviewAdapter;", "", "canCreateThread", "configureFlexInputContentPages", "(Z)V", "Lcom/discord/app/AppFragment;", "fragment", "configureFlexInputFragment", "(Lcom/discord/app/AppFragment;)V", "Lcom/lytefast/flexinput/FlexInputListener;", "inputListener", "setInputListener", "(Lcom/lytefast/flexinput/FlexInputListener;)V", "Lcom/lytefast/flexinput/viewmodel/FlexInputViewModel;", "viewModel", "setViewModel", "(Lcom/lytefast/flexinput/viewmodel/FlexInputViewModel;)V", "attachment", "addExternalAttachment", "(Lcom/lytefast/flexinput/model/Attachment;)V", "Lcom/lytefast/flexinput/fragment/FlexInputFragment;", "flexInputFragment", "Lcom/lytefast/flexinput/fragment/FlexInputFragment;", "<init>", "(Lcom/lytefast/flexinput/fragment/FlexInputFragment;)V", "DiscordFilesFragment", "DiscordMediaFragment", "PermissionsEmptyListAdapter", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatInputAttachments {
    private final FlexInputFragment flexInputFragment;

    /* compiled from: WidgetChatInputAttachments.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/chat/input/WidgetChatInputAttachments$DiscordFilesFragment;", "Lcom/lytefast/flexinput/fragment/FilesFragment;", "Landroid/view/View$OnClickListener;", "onClickListener", "Lcom/lytefast/flexinput/adapters/EmptyListAdapter;", "newPermissionsRequestAdapter", "(Landroid/view/View$OnClickListener;)Lcom/lytefast/flexinput/adapters/EmptyListAdapter;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class DiscordFilesFragment extends FilesFragment {
        @Override // com.lytefast.flexinput.fragment.FilesFragment
        public EmptyListAdapter newPermissionsRequestAdapter(View.OnClickListener onClickListener) {
            Intrinsics3.checkNotNullParameter(onClickListener, "onClickListener");
            return new PermissionsEmptyListAdapter(R.layout.widget_chat_input_perm_req_files, R.id.action_btn, onClickListener);
        }
    }

    /* compiled from: WidgetChatInputAttachments.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/chat/input/WidgetChatInputAttachments$DiscordMediaFragment;", "Lcom/lytefast/flexinput/fragment/MediaFragment;", "Landroid/view/View$OnClickListener;", "onClickListener", "Lcom/lytefast/flexinput/adapters/EmptyListAdapter;", "newPermissionsRequestAdapter", "(Landroid/view/View$OnClickListener;)Lcom/lytefast/flexinput/adapters/EmptyListAdapter;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class DiscordMediaFragment extends MediaFragment {
        @Override // com.lytefast.flexinput.fragment.MediaFragment
        public EmptyListAdapter newPermissionsRequestAdapter(View.OnClickListener onClickListener) {
            Intrinsics3.checkNotNullParameter(onClickListener, "onClickListener");
            return new PermissionsEmptyListAdapter(R.layout.widget_chat_input_perm_req_files, R.id.action_btn, onClickListener);
        }
    }

    /* compiled from: WidgetChatInputAttachments.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\t\u001a\u00020\u0004\u0012\b\b\u0001\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0007\u001a\u00060\u0006R\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/chat/input/WidgetChatInputAttachments$PermissionsEmptyListAdapter;", "Lcom/lytefast/flexinput/adapters/EmptyListAdapter;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/lytefast/flexinput/adapters/EmptyListAdapter$ViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/lytefast/flexinput/adapters/EmptyListAdapter$ViewHolder;", "itemLayoutId", "actionBtnId", "Landroid/view/View$OnClickListener;", "onClickListener", "<init>", "(IILandroid/view/View$OnClickListener;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class PermissionsEmptyListAdapter extends EmptyListAdapter {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PermissionsEmptyListAdapter(@LayoutRes int i, @IdRes int i2, View.OnClickListener onClickListener) {
            super(i, i2, onClickListener);
            Intrinsics3.checkNotNullParameter(onClickListener, "onClickListener");
        }

        @Override // com.lytefast.flexinput.adapters.EmptyListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder(viewGroup, i);
        }

        @Override // com.lytefast.flexinput.adapters.EmptyListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public EmptyListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            EmptyListAdapter.ViewHolder viewHolderOnCreateViewHolder = super.onCreateViewHolder(parent, viewType);
            View view = viewHolderOnCreateViewHolder.itemView;
            int i = R.id.action_btn;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.action_btn);
            if (materialButton != null) {
                i = R.id.perm_req_text;
                TextView textView = (TextView) view.findViewById(R.id.perm_req_text);
                if (textView != null) {
                    Intrinsics3.checkNotNullExpressionValue(new WidgetChatInputPermReqFilesBinding((LinearLayout) view, materialButton, textView), "WidgetChatInputPermReqFi…ing.bind(holder.itemView)");
                    Intrinsics3.checkNotNullExpressionValue(textView, "binding.permReqText");
                    FormatUtils.n(textView, R.string.system_permission_request_files, new Object[0], null, 4);
                    return viewHolderOnCreateViewHolder;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
    }

    /* compiled from: WidgetChatInputAttachments.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$addExternalAttachment$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Attachment $attachment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Attachment attachment) {
            super(0);
            this.$attachment = attachment;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetChatInputAttachments.access$getFlexInputFragment$p(WidgetChatInputAttachments.this).f(this.$attachment);
        }
    }

    /* compiled from: WidgetChatInputAttachments.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$configureFlexInputContentPages$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $canCreateThread;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(0);
            this.$canCreateThread = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Context contextRequireContext = WidgetChatInputAttachments.access$getFlexInputFragment$p(WidgetChatInputAttachments.this).requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "flexInputFragment.requireContext()");
            List listMutableListOf = Collections2.mutableListOf(new WidgetChatInputAttachments$configureFlexInputContentPages$1$pageArray$1(contextRequireContext, DrawableCompat.getThemedDrawableRes$default(contextRequireContext, R.attr.ic_flex_input_image, 0, 2, (Object) null), R.string.attachment_media), new WidgetChatInputAttachments$configureFlexInputContentPages$1$pageArray$2(contextRequireContext, DrawableCompat.getThemedDrawableRes$default(contextRequireContext, R.attr.ic_flex_input_file, 0, 2, (Object) null), R.string.attachment_files), new WidgetChatInputAttachments$configureFlexInputContentPages$1$pageArray$3(contextRequireContext, DrawableCompat.getThemedDrawableRes$default(contextRequireContext, R.attr.ic_flex_input_add_a_photo, 0, 2, (Object) null), R.string.camera));
            if (this.$canCreateThread) {
                listMutableListOf.add(new WidgetChatInputAttachments$configureFlexInputContentPages$1$page$1(contextRequireContext, DrawableCompat.getThemedDrawableRes$default(contextRequireContext, R.attr.ic_flex_input_create_thread, 0, 2, (Object) null), R.string.create_thread));
            }
            FlexInputFragment flexInputFragmentAccess$getFlexInputFragment$p = WidgetChatInputAttachments.access$getFlexInputFragment$p(WidgetChatInputAttachments.this);
            Object[] array = listMutableListOf.toArray(new AddContentPagerAdapter4.a[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            AddContentPagerAdapter4.a[] aVarArr = (AddContentPagerAdapter4.a[]) array;
            Objects.requireNonNull(flexInputFragmentAccess$getFlexInputFragment$p);
            Intrinsics3.checkNotNullParameter(aVarArr, "pageSuppliers");
            flexInputFragmentAccess$getFlexInputFragment$p.r = aVarArr;
            Iterator<Function0<Unit>> it = flexInputFragmentAccess$getFlexInputFragment$p.onContentPagesInitializedUpdates.iterator();
            while (it.hasNext()) {
                it.next().invoke();
            }
            flexInputFragmentAccess$getFlexInputFragment$p.onContentPagesInitializedUpdates.clear();
        }
    }

    /* compiled from: WidgetChatInputAttachments.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$configureFlexInputFragment$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AppFragment $fragment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AppFragment appFragment) {
            super(0);
            this.$fragment = appFragment;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetChatInputAttachments.this.configureFlexInputContentPages(false);
            FlexInputFragment flexInputFragmentAccess$getFlexInputFragment$p = WidgetChatInputAttachments.access$getFlexInputFragment$p(WidgetChatInputAttachments.this);
            FileManager fileManager = this.$fragment.getFileManager();
            Objects.requireNonNull(flexInputFragmentAccess$getFlexInputFragment$p);
            Intrinsics3.checkNotNullParameter(fileManager, "<set-?>");
            flexInputFragmentAccess$getFlexInputFragment$p.fileManager = fileManager;
            flexInputFragmentAccess$getFlexInputFragment$p.keyboardManager = new WidgetChatInputAttachments$configureFlexInputFragment$1$$special$$inlined$apply$lambda$1(this);
            WidgetChatInputAttachments.access$getFlexInputFragment$p(WidgetChatInputAttachments.this).l().setInputContentHandler(new WidgetChatInputAttachments$configureFlexInputFragment$1$$special$$inlined$apply$lambda$2(this));
            AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapterAccess$createPreviewAdapter = WidgetChatInputAttachments.access$createPreviewAdapter(WidgetChatInputAttachments.this, this.$fragment.getContext());
            Intrinsics3.checkNotNullParameter(attachmentPreviewAdapterAccess$createPreviewAdapter, "previewAdapter");
            attachmentPreviewAdapterAccess$createPreviewAdapter.selectionAggregator.initFrom(flexInputFragmentAccess$getFlexInputFragment$p.b());
            flexInputFragmentAccess$getFlexInputFragment$p.attachmentPreviewAdapter = attachmentPreviewAdapterAccess$createPreviewAdapter;
            RecyclerView recyclerView = flexInputFragmentAccess$getFlexInputFragment$p.j().d;
            Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.attachmentPreviewList");
            AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapter = flexInputFragmentAccess$getFlexInputFragment$p.attachmentPreviewAdapter;
            if (attachmentPreviewAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("attachmentPreviewAdapter");
            }
            recyclerView.setAdapter(attachmentPreviewAdapter);
            WidgetChatInputAttachments widgetChatInputAttachments = WidgetChatInputAttachments.this;
            FragmentManager childFragmentManager = this.$fragment.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
            Fragment fragmentAccess$createAndConfigureExpressionFragment = WidgetChatInputAttachments.access$createAndConfigureExpressionFragment(widgetChatInputAttachments, childFragmentManager, WidgetChatInputAttachments.access$getFlexInputFragment$p(WidgetChatInputAttachments.this).l());
            if (fragmentAccess$createAndConfigureExpressionFragment == null) {
                return;
            }
            flexInputFragmentAccess$getFlexInputFragment$p.getChildFragmentManager().beginTransaction().replace(com.lytefast.flexinput.R.f.expression_tray_container, fragmentAccess$createAndConfigureExpressionFragment, fragmentAccess$createAndConfigureExpressionFragment.getClass().getSimpleName()).commit();
            AppCompatImageButton appCompatImageButton = flexInputFragmentAccess$getFlexInputFragment$p.j().i;
            Intrinsics3.checkNotNullExpressionValue(appCompatImageButton, "binding.expressionBtn");
            appCompatImageButton.setVisibility(0);
        }
    }

    /* compiled from: WidgetChatInputAttachments.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "()Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$configureFlexInputFragment$2, reason: invalid class name */
    public static final class AnonymousClass2<R> implements Func0<Boolean> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            FlexInputViewModel flexInputViewModel = WidgetChatInputAttachments.access$getFlexInputFragment$p(WidgetChatInputAttachments.this).viewModel;
            Boolean boolValueOf = flexInputViewModel != null ? Boolean.valueOf(flexInputViewModel.hideExpressionTray()) : null;
            return boolValueOf != null ? boolValueOf : Boolean.FALSE;
        }
    }

    /* compiled from: WidgetChatInputAttachments.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$createAndConfigureExpressionFragment$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FlexInputViewModel flexInputViewModel = WidgetChatInputAttachments.access$getFlexInputFragment$p(WidgetChatInputAttachments.this).viewModel;
            if (flexInputViewModel != null) {
                flexInputViewModel.hideExpressionTray();
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: WidgetChatInputAttachments.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/lytefast/flexinput/model/Attachment;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/lytefast/flexinput/adapters/AttachmentPreviewAdapter;", "previewAdapter", "Lcom/lytefast/flexinput/utils/SelectionAggregator;", "invoke", "(Lcom/lytefast/flexinput/adapters/AttachmentPreviewAdapter;)Lcom/lytefast/flexinput/utils/SelectionAggregator;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$createPreviewAdapter$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends Lambda implements Function1<AttachmentPreviewAdapter<T>, SelectionAggregator<T>> {
        public final /* synthetic */ Context $context;

        /* compiled from: WidgetChatInputAttachments.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0013\u0010\u0003\u001a\u00020\u0002*\u00028\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\u0007\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/discord/widgets/chat/input/WidgetChatInputAttachments$createPreviewAdapter$1$1", "Lcom/lytefast/flexinput/utils/SelectionAggregator;", "", "track", "(Lcom/lytefast/flexinput/model/Attachment;)V", "Lcom/lytefast/flexinput/utils/SelectionCoordinator;", "selectionCoordinator", "registerSelectionCoordinatorInternal", "(Lcom/lytefast/flexinput/utils/SelectionCoordinator;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$createPreviewAdapter$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02531 extends SelectionAggregator<T> {
            public final /* synthetic */ AttachmentPreviewAdapter $previewAdapter;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02531(AttachmentPreviewAdapter attachmentPreviewAdapter, AttachmentPreviewAdapter attachmentPreviewAdapter2) {
                super(attachmentPreviewAdapter2, null, null, null, 14, null);
                this.$previewAdapter = attachmentPreviewAdapter;
            }

            public static final /* synthetic */ void access$track(C02531 c02531, Attachment attachment) {
                c02531.track(attachment);
            }

            /* JADX WARN: Incorrect types in method signature: (TT;)V */
            private final void track(Attachment attachment) {
                String source = attachment instanceof SourcedAttachment ? ((SourcedAttachment) attachment).getSource() : AnalyticsTracker.ATTACHMENT_SOURCE_PICKER;
                try {
                    int size = WidgetChatInputAttachments.access$getFlexInputFragment$p(WidgetChatInputAttachments.this).b().getSize();
                    Context context = AnonymousClass1.this.$context;
                    AnalyticsTracker.addAttachment(source, AttachmentUtils.getMimeType(attachment, context != null ? context.getContentResolver() : null), size);
                } catch (Throwable th) {
                    AppLog.g.i("Analytic error on attachment update", th);
                }
            }

            @Override // com.lytefast.flexinput.utils.SelectionAggregator
            public void registerSelectionCoordinatorInternal(SelectionCoordinator<T, ?> selectionCoordinator) {
                Intrinsics3.checkNotNullParameter(selectionCoordinator, "selectionCoordinator");
                super.registerSelectionCoordinatorInternal(selectionCoordinator);
                WidgetChatInputAttachments$createPreviewAdapter$1$1$registerSelectionCoordinatorInternal$1 widgetChatInputAttachments$createPreviewAdapter$1$1$registerSelectionCoordinatorInternal$1 = new WidgetChatInputAttachments$createPreviewAdapter$1$1$registerSelectionCoordinatorInternal$1(this, selectionCoordinator.itemSelectionListener);
                Intrinsics3.checkNotNullParameter(widgetChatInputAttachments$createPreviewAdapter$1$1$registerSelectionCoordinatorInternal$1, "<set-?>");
                selectionCoordinator.itemSelectionListener = widgetChatInputAttachments$createPreviewAdapter$1$1$registerSelectionCoordinatorInternal$1;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke((AttachmentPreviewAdapter) obj);
        }

        public final SelectionAggregator<T> invoke(AttachmentPreviewAdapter<T> attachmentPreviewAdapter) {
            Intrinsics3.checkNotNullParameter(attachmentPreviewAdapter, "previewAdapter");
            return new C02531(attachmentPreviewAdapter, attachmentPreviewAdapter);
        }
    }

    public WidgetChatInputAttachments(FlexInputFragment flexInputFragment) {
        Intrinsics3.checkNotNullParameter(flexInputFragment, "flexInputFragment");
        this.flexInputFragment = flexInputFragment;
    }

    public static final /* synthetic */ Fragment access$createAndConfigureExpressionFragment(WidgetChatInputAttachments widgetChatInputAttachments, FragmentManager fragmentManager, TextView textView) {
        return widgetChatInputAttachments.createAndConfigureExpressionFragment(fragmentManager, textView);
    }

    public static final /* synthetic */ AttachmentPreviewAdapter access$createPreviewAdapter(WidgetChatInputAttachments widgetChatInputAttachments, Context context) {
        return widgetChatInputAttachments.createPreviewAdapter(context);
    }

    public static final /* synthetic */ FlexInputFragment access$getFlexInputFragment$p(WidgetChatInputAttachments widgetChatInputAttachments) {
        return widgetChatInputAttachments.flexInputFragment;
    }

    public static final /* synthetic */ void access$setAttachmentFromPicker(WidgetChatInputAttachments widgetChatInputAttachments, Context context, InputContentInfoCompat inputContentInfoCompat) {
        widgetChatInputAttachments.setAttachmentFromPicker(context, inputContentInfoCompat);
    }

    private final Fragment createAndConfigureExpressionFragment(FragmentManager fragmentManager, TextView chatInput) {
        WidgetChatInputAttachments$createAndConfigureExpressionFragment$emojiPickerListener$1 widgetChatInputAttachments$createAndConfigureExpressionFragment$emojiPickerListener$1 = new WidgetChatInputAttachments$createAndConfigureExpressionFragment$emojiPickerListener$1(this);
        WidgetChatInputAttachments$createAndConfigureExpressionFragment$stickerPickerListener$1 widgetChatInputAttachments$createAndConfigureExpressionFragment$stickerPickerListener$1 = new WidgetChatInputAttachments$createAndConfigureExpressionFragment$stickerPickerListener$1(this);
        WidgetChatInputAttachments$createAndConfigureExpressionFragment$onBackspacePressedListener$1 widgetChatInputAttachments$createAndConfigureExpressionFragment$onBackspacePressedListener$1 = new WidgetChatInputAttachments$createAndConfigureExpressionFragment$onBackspacePressedListener$1(chatInput);
        Fragment fragmentFindFragmentById = fragmentManager.findFragmentById(R.id.expression_tray_container);
        if (!(fragmentFindFragmentById instanceof WidgetExpressionTray)) {
            fragmentFindFragmentById = null;
        }
        WidgetExpressionTray widgetExpressionTray = (WidgetExpressionTray) fragmentFindFragmentById;
        if (widgetExpressionTray == null) {
            widgetExpressionTray = new WidgetExpressionTray();
        }
        widgetExpressionTray.setEmojiPickerListener(widgetChatInputAttachments$createAndConfigureExpressionFragment$emojiPickerListener$1);
        widgetExpressionTray.setStickerPickerListener(widgetChatInputAttachments$createAndConfigureExpressionFragment$stickerPickerListener$1);
        widgetExpressionTray.setOnBackspacePressedListener(widgetChatInputAttachments$createAndConfigureExpressionFragment$onBackspacePressedListener$1);
        widgetExpressionTray.setOnEmojiSearchOpenedListener(new AnonymousClass1());
        return widgetExpressionTray;
    }

    private final <T extends Attachment<? extends Object>> AttachmentPreviewAdapter<T> createPreviewAdapter(Context context) {
        WidgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1 widgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1 = new WidgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1(this);
        Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment("2021-10_android_attachment_bottom_sheet", true);
        return new AttachmentPreviewAdapter<>(userExperiment != null && userExperiment.getBucket() == 1, widgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1, new AnonymousClass1(context));
    }

    private final void setAttachmentFromPicker(Context context, InputContentInfoCompat inputContentInfoCompat) {
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver != null) {
            this.flexInputFragment.f(new SourcedAttachment(Attachment.INSTANCE.c(inputContentInfoCompat, contentResolver, true, FormatUtils.h(context, R.string.attachment_filename_unknown, new Object[0], null, 4).toString()), AnalyticsTracker.ATTACHMENT_SOURCE_KEYBOARD));
        }
    }

    public final void addExternalAttachment(Attachment<? extends Object> attachment) {
        Intrinsics3.checkNotNullParameter(attachment, "attachment");
        this.flexInputFragment.i(new AnonymousClass1(attachment));
    }

    public final void configureFlexInputContentPages(boolean canCreateThread) {
        this.flexInputFragment.i(new AnonymousClass1(canCreateThread));
    }

    public final void configureFlexInputFragment(AppFragment fragment) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        this.flexInputFragment.i(new AnonymousClass1(fragment));
        fragment.setOnBackPressed(new AnonymousClass2(), 1);
    }

    public final void setInputListener(FlexInputListener inputListener) {
        Intrinsics3.checkNotNullParameter(inputListener, "inputListener");
        FlexInputFragment flexInputFragment = this.flexInputFragment;
        Objects.requireNonNull(flexInputFragment);
        Intrinsics3.checkNotNullParameter(inputListener, "inputListener");
        flexInputFragment.inputListener = inputListener;
    }

    public final void setViewModel(FlexInputViewModel viewModel) {
        this.flexInputFragment.viewModel = viewModel;
    }
}
