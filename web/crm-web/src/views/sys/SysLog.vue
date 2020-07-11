<template>
  <div>
    <el-tooltip class="item" effect="dark" content="仅仅为了减轻数据库的存储压力，若要在项目中使用，请仔细翻阅代码" placement="left-start">
      <el-button type="danger" @click="cleanLog" style="margin-bottom: 5px" icon="el-icon-warning-outline">清空记录</el-button>
    </el-tooltip>
    <el-table :data="logList" height="430" border style="width: 100%">
      <el-table-column prop="operDesc" label="内容" width="180">
      </el-table-column>
      <el-table-column prop="operModul" label="所属模块" width="180">
      </el-table-column>
      <el-table-column prop="operUrl" label="请求地址"> </el-table-column>
      <el-table-column prop="operIp" label="客户端IP" width="120">
      </el-table-column>
      <el-table-column prop="operType" label="请求类型" width="80">
      </el-table-column>
      <el-table-column prop="operUserName" label="请求用户" width="100">
      </el-table-column>
      <el-table-column prop="operCreateTime" label="请求时间" width="200">
        <template slot-scope="scope">
          {{ scope.row.operCreateTime | dateYMDHMSFormat }}
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="currentChange"
      :current-page="pageInfo.pageNum"
      :page-sizes="[5, 10, 20, 50]"
      :page-size="pageInfo.pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="pageInfo.total"
    >
    </el-pagination>
  </div>
</template>

<script>
export default {
  name: "SysLog",
  data() {
    return {
      logList: [],
      pageInfo: {
        pageNum: 1,
        pageSize: 10
      } //分页对象
    };
  },
  mounted() {
    this.selectLogList();
  },
  methods: {
    selectLogList() {
      this.postRequest("/sys/log/getOperLog", this.pageInfo).then(resp => {
        if (resp) {
          this.$set(this, "logList", resp.list);
          this.$set(this.pageInfo, "pageNum", resp.pageNum);
          this.$set(this.pageInfo, "pageSize", resp.pageSize);
          this.$set(this.pageInfo, "total", resp.total);
        }
      });
    },
    handleSizeChange() {
      this.selectLogList();
    },
    currentChange(pageNum) {
      this.$set(this.pageInfo, "pageNum", pageNum);
      this.selectLogList();
    },
    cleanLog() {
      this.deleteRequest("/sys/log/").then(resp => {
        if (resp && resp.status == 200) {
          this.$message.success(resp.msg);
          this.selectLogList();
        }
      });
    }
  }
};
</script>

<style scoped></style>
