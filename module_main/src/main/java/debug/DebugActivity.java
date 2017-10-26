package debug;

import com.wisdudu.lib_common.base.FragmentActivity;
import com.wisdudu.module_main.MainFragment;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * 文件描述：用于组件开发时承载Fragment的DebugActivity
 * <p>
 * 作者：   Created by sven on 2017/10/25.
 */

public class DebugActivity extends FragmentActivity {
    @Override
    protected SupportFragment loadFragment() {
        return MainFragment.newInstance();
    }
}
