package androidx.browser.browseractions;

import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.browser.R;
import androidx.core.widget.TextViewCompat;
import com.discord.restapi.RestAPIBuilder;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public class BrowserActionsFallbackMenuUi implements AdapterView.OnItemClickListener {
    private static final String TAG = "BrowserActionskMenuUi";

    @Nullable
    private BrowserActionsFallbackMenuDialog mBrowserActionsDialog;
    public final Context mContext;
    private final List<BrowserActionItem> mMenuItems;

    @Nullable
    public BrowserActionsFallMenuUiListener mMenuUiListener;
    public final Uri mUri;

    /* renamed from: androidx.browser.browseractions.BrowserActionsFallbackMenuUi$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ((ClipboardManager) BrowserActionsFallbackMenuUi.this.mContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("url", BrowserActionsFallbackMenuUi.this.mUri.toString()));
            Toast.makeText(BrowserActionsFallbackMenuUi.this.mContext, BrowserActionsFallbackMenuUi.this.mContext.getString(R.string.copy_toast_msg), 0).show();
        }
    }

    /* renamed from: androidx.browser.browseractions.BrowserActionsFallbackMenuUi$2, reason: invalid class name */
    public class AnonymousClass2 implements DialogInterface.OnShowListener {
        public final /* synthetic */ View val$view;

        public AnonymousClass2(View view) {
            this.val$view = view;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            BrowserActionsFallMenuUiListener browserActionsFallMenuUiListener = BrowserActionsFallbackMenuUi.this.mMenuUiListener;
            if (browserActionsFallMenuUiListener == null) {
                Log.e(BrowserActionsFallbackMenuUi.TAG, "Cannot trigger menu item listener, it is null");
            } else {
                browserActionsFallMenuUiListener.onMenuShown(this.val$view);
            }
        }
    }

    /* renamed from: androidx.browser.browseractions.BrowserActionsFallbackMenuUi$3, reason: invalid class name */
    public class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ TextView val$urlTextView;

        public AnonymousClass3(TextView textView) {
            this.val$urlTextView = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextViewCompat.getMaxLines(this.val$urlTextView) == Integer.MAX_VALUE) {
                this.val$urlTextView.setMaxLines(1);
                this.val$urlTextView.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.val$urlTextView.setMaxLines(Integer.MAX_VALUE);
                this.val$urlTextView.setEllipsize(null);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @VisibleForTesting
    public interface BrowserActionsFallMenuUiListener {
        void onMenuShown(View view);
    }

    public BrowserActionsFallbackMenuUi(@NonNull Context context, @NonNull Uri uri, @NonNull List<BrowserActionItem> list) {
        this.mContext = context;
        this.mUri = uri;
        this.mMenuItems = buildFallbackMenuItemList(list);
    }

    private Runnable buildCopyAction() {
        return new AnonymousClass1();
    }

    @NonNull
    private List<BrowserActionItem> buildFallbackMenuItemList(List<BrowserActionItem> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BrowserActionItem(this.mContext.getString(R.string.fallback_menu_item_open_in_browser), buildOpenInBrowserAction()));
        arrayList.add(new BrowserActionItem(this.mContext.getString(R.string.fallback_menu_item_copy_link), buildCopyAction()));
        arrayList.add(new BrowserActionItem(this.mContext.getString(R.string.fallback_menu_item_share_link), buildShareAction()));
        arrayList.addAll(list);
        return arrayList;
    }

    private PendingIntent buildOpenInBrowserAction() {
        return PendingIntent.getActivity(this.mContext, 0, new Intent("android.intent.action.VIEW", this.mUri), 0);
    }

    private PendingIntent buildShareAction() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", this.mUri.toString());
        intent.setType(RestAPIBuilder.CONTENT_TYPE_TEXT);
        return PendingIntent.getActivity(this.mContext, 0, intent, 0);
    }

    private BrowserActionsFallbackMenuView initMenuView(View view) {
        BrowserActionsFallbackMenuView browserActionsFallbackMenuView = (BrowserActionsFallbackMenuView) view.findViewById(R.id.browser_actions_menu_view);
        TextView textView = (TextView) view.findViewById(R.id.browser_actions_header_text);
        textView.setText(this.mUri.toString());
        textView.setOnClickListener(new AnonymousClass3(textView));
        ListView listView = (ListView) view.findViewById(R.id.browser_actions_menu_items);
        listView.setAdapter((ListAdapter) new BrowserActionsFallbackMenuAdapter(this.mMenuItems, this.mContext));
        listView.setOnItemClickListener(this);
        return browserActionsFallbackMenuView;
    }

    public void displayMenu() {
        View viewInflate = LayoutInflater.from(this.mContext).inflate(R.layout.browser_actions_context_menu_page, (ViewGroup) null);
        BrowserActionsFallbackMenuDialog browserActionsFallbackMenuDialog = new BrowserActionsFallbackMenuDialog(this.mContext, initMenuView(viewInflate));
        this.mBrowserActionsDialog = browserActionsFallbackMenuDialog;
        browserActionsFallbackMenuDialog.setContentView(viewInflate);
        if (this.mMenuUiListener != null) {
            this.mBrowserActionsDialog.setOnShowListener(new AnonymousClass2(viewInflate));
        }
        this.mBrowserActionsDialog.show();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) throws PendingIntent.CanceledException {
        BrowserActionItem browserActionItem = this.mMenuItems.get(i);
        if (browserActionItem.getAction() != null) {
            try {
                browserActionItem.getAction().send();
            } catch (PendingIntent.CanceledException e) {
                Log.e(TAG, "Failed to send custom item action", e);
            }
        } else if (browserActionItem.getRunnableAction() != null) {
            browserActionItem.getRunnableAction().run();
        }
        BrowserActionsFallbackMenuDialog browserActionsFallbackMenuDialog = this.mBrowserActionsDialog;
        if (browserActionsFallbackMenuDialog == null) {
            Log.e(TAG, "Cannot dismiss dialog, it has already been dismissed.");
        } else {
            browserActionsFallbackMenuDialog.dismiss();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @VisibleForTesting
    public void setMenuUiListener(@Nullable BrowserActionsFallMenuUiListener browserActionsFallMenuUiListener) {
        this.mMenuUiListener = browserActionsFallMenuUiListener;
    }
}
