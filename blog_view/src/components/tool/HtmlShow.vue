<template>
  <div v-html="htmlContent" class="editor-content-view">

  </div>
</template>

<script>
export default {
  name: 'HtmlShow',
  props: {
    htmlContent: String,
  },
}
</script>

<style >
/* table {
  border-collapse: collapse;
  margin: 0 auto;
  text-align: center;
}
table tbody td,
table tbody th {
  border: 1px solid #cad9ea;
  color: #666;
  height: 30px;
}
table tbody th {
  background-color: #cce8eb;
  width: 100px;
}
table tbody tr:nth-child(odd) {
  background: #fff;
}
table tbody tr:nth-child(even) {
  background: #f5fafa;
} */
.editor-content-view {
  border-radius: 5px;
  padding: 0 10px;
  margin-top: 20px;
  overflow-x: auto;
  text-align: left;
}

.editor-content-view *{
  margin-bottom: 20px;
}

.editor-content-view p,
.editor-content-view li {
  white-space: pre-wrap; /* 保留空格 */
}

.editor-content-view blockquote {
  border-left: 8px solid #d0e5f2;
  padding: 10px 10px;
  margin: 10px 0;
  background-color: #f1f1f1;
}

.editor-content-view code {
  font-family: monospace;
  background-color: #eee;
  padding: 3px;
  border-radius: 3px;
}
.editor-content-view pre>code {
  display: block;
  padding: 10px;
}

.editor-content-view table {
  border-collapse: collapse;
}
.editor-content-view td,
.editor-content-view th {
  border: 1px solid #ccc;
  min-width: 50px;
  height: 35px;
  text-align: center;
}
.editor-content-view th {
  background-color: #f1f1f1;
}

.editor-content-view ul,
.editor-content-view ol {
  padding-left: 20px;
}

.editor-content-view input[type="checkbox"] {
  margin-right: 5px;
}
</style>
